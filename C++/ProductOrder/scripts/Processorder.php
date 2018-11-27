<?php

/*
 * Purpose: To Process a users order into a Cart and act as a Display to the user
 * Author: Zachary Higgs
 * Date: 11/5/2018
 */

/**
 * Description of Processorder
 *
 * @author Zach-Win
 */



class Processorder {
    private $finalOrder = array(); //This must be a Array of arrays, Each array "object" within this is a product
    private $FirstName;
    private $LastName;
    private $Email;
    private $Date;
    
    private $HST = 15;
    //Hold a list of costs for each product on offer, this is a hack solution as no value is given beyond what's shown in the main index page
    private $productCost = array (
        "deluminator" => 150,
        "snitch" => 400,
        "cloak" => 99.99,
        "map" => 50,
        "stone" => 19.95,
        "wand" => 69.99
    ); 
    
    private $totalCost;
    
    
    public function __construct() {
        $this->setFirstName(filter_input(INPUT_POST, "fname", FILTER_SANITIZE_STRING));
        $this->setLastName(filter_input(INPUT_POST, "lname", FILTER_SANITIZE_STRING));
        $this->setEmail(filter_input(INPUT_POST, "useremail", FILTER_SANITIZE_EMAIL));
        $this->setDate(filter_input(INPUT_POST, "odate", FILTER_DEFAULT));
        $this->processOrder();
    }
    
    /*
     * This should produce an array comprised:
     * Array([0] => Array([product] => "", [quantity] => int), [1] ....);
     */
    public function processOrder(){
        $orderProduct = filter_input(INPUT_POST, "product", FILTER_SANITIZE_STRING, FILTER_REQUIRE_ARRAY);
        $orderQuantity = filter_input(INPUT_POST, "quantity", FILTER_SANITIZE_NUMBER_INT, FILTER_REQUIRE_ARRAY); 
        
        
        
        
        
        if(gettype($orderProduct) !== "array"){
            throw new Exception("Product not Array");
        }
        if(gettype($orderQuantity) !== "array"){
            throw new Exception("Quantity not Array");
        }
        
        //Take the Keys of Product Cost... The current Implementation of the Index is unable to handle this kind of operation
        $orderProduct = array_keys($this->productCost);
        
        //Define the Max Size, This is to keep things consistant and to ensure that we're not taking a quantity without a product
        try{
            $MAXLENGTH = count($orderProduct);
        } catch (Exception $ex) {

        }
        
        
        for($i = 0; $i < $MAXLENGTH; $i++){
            if($orderQuantity[$i] > 0){ //Make sure the Object is greater then 0
                $this->finalOrder[] = $this->createItem($orderProduct[$i],$orderQuantity[$i]);
            }
        }
    }
    
    public function TallyTotal(){
        
        foreach($this->finalOrder as $item){
            try{
                for($i = 0; $i < $item["quantity"]; $i++) {
                    $this->totalCost += $this->productCost[$item["product"]];
                }
            } catch (OutOfBoundsException $e){
                //This is to make sure a users bin is still processed but sans the erronious product given, If this were a real use, We'd want to chuck out the entire order but still handle this exception
                continue;
            } catch (Exception $e){
                echo $e->getTraceAsString();
            }
            }
            return $this->totalCost;
        } 
        
    public function TallyOne($item){
        $total = 0;
        try{
            for($i = 0; $i < $item["quantity"]; $i++){
                $total += $this->productCost[$item["product"]];
            }
        } catch (Exception $ex) {
            echo  $ex->getTraceAsString();
        }
        return $total;
    }
    
    /**
     * Create an Item from a Product name and a quantity
     * @param type $product
     * @param type $quantity
     * @return type
     */
    public function createItem($product, $quantity){
        $item = array();
        $item["product"] = $product;
        $item["quantity"] = $quantity;
        return $item;
    }
    
    public function calcHST(){
        return ($this->totalCost * ($this->HST / 100));
    }
    
    public function calcGrandTotal(){
        return $this->totalCost + $this->calcHST();
    }
    public function setFirstName($value){
        $this->FirstName = $value;
    }
    public function setLastName($value){
        $this->LastName = $value;
    }
    public function setEmail($value){
        $this->Email = $value;
    }
    public function setDate($value){  
        $this->Date = $value;
    } 
    
    public function getFirstName(){
        return $this->FirstName;
    }
    public function getLastName(){
        return $this->LastName;
    }
    public function getEmail(){
        return $this->Email;
    }
    
    public function displayName(){
        echo "<p><b>Name: ". $this->getFirstName() . " " . $this->getLastName() ."</b></p>";
    }
    public function displayEmail(){
        echo "<p><b>Email: " . $this->Email . "</b></p>";
    }
    public function displayDate(){
        echo "<p><b>Your purchases on " . $this->Date . "</b></p>";
    }
    
    public function displayTable(){
        $tableTop = "<table> "
                . "<tr>"
                . "<th> Product </th>"
                . "<th> Unit Price </th>"
                . "<th> Quantity </th>"
                . "<th> Total </th>"
                . "</tr>";
        $tableBottom = "";
        $tableBody = "";
        foreach($this->finalOrder as $item){
            $tableBody .= "<tr>";
            try{
                $tableBody .= "<td>" . $item["product"] . "</td>"; // Add the product name
                $tableBody .= "<td>" . $this->productCost[$item["product"]] . "</td>"; // Display the cost of one item
                $tableBody .= "<td>" . $item["quantity"] . "</td>"; // Display the quantity
                $tableBody .= "<td>" . $this->TallyOne($item) . "</td>"; //Display the total for all ordered
                $tableBody .= "</tr>";
            } catch (Exception $ex) {

            } 
        }
        $tableBottom .= "<tr>"
                . "<td><b> Item Total </b></td>"
                . "<td></td>"
                . "<td></td>"
                . "<td><b>$" . $this->TallyTotal() . "</b></td>"
                . "</tr>"
                . "<tr>"
                . "<td><b>HST:</b></td>"
                . "<td></td>"
                . "<td></td>"
                . "<td><b>$" . $this->calcHST() . "</b></td>"
                . "</tr>"
                . "<tr>"
                . "<td><b>Grand Total:</b></td>"
                . "<td></td>"
                . "<td></td>"
                . "<td><b>$" . $this->calcGrandTotal() . "</b></td>"
                . "</tr>"
                . "</table>";
        echo $tableTop . $tableBody . $tableBottom;
    }
    public function displayBody(){
        $this->displayName();
        $this->displayEmail();
        $this->displayDate();
        $this->displayTable();
    }
    
}
