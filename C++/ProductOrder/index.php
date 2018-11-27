<!DOCTYPE html>
<!-- Product Order Form  -->
<!-- Author: Kathleen Stewart -->
<!-- Date: October 2016 -->
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Product Order</title>
        <style>
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
                padding:5px;
            }
            input[type=number] {
                width:4em;
            }
        </style>
    </head>
    <body>
        <h1>Product Order Form</h1>
        <p>
            Please fill out our form to place an order
        </p>
        <h5>* denotes required fields</h5>
        <form action="Cart.php" method="POST" name="orderform" id="orderform">
            <fieldset name="userfieldset" id="userfieldset">
                <legend>User Information</legend>
                <p>
                    <label for="fname">First Name: </label>
                    <input type="text" name="fname" id="fname" placeholder="Enter First Name" maxlength="100" size="25" autofocus pattern="[A-Za-z\s'-]{1,100}"> 
                </p>
                <p>
                    <label for="lname">* Last Name: </label>
                    <input type="text" name="lname" id="lname" placeholder="Enter Last Name" maxlength="100" size="25" required pattern="[A-Za-z\s'-]{1,100}">
                </p>
                <p>
                    <label for="email">* E-mail Address: </label> 
                    <input name="useremail" id="useremail" type="email" size="25" maxlength="100" required> sample123@company.org
                </p>
            </fieldset>
            <fieldset name="orderfieldset" id="orderfieldset">
                <legend>Order Information</legend>
                <p>
                    <label for="odate">* OrderDate: </label>
                    <input type="date" name="odate" id="odate" required> (mm/dd/yyyy)
                </p>
                <p>
                <table>
                    <tr>
                        <th>Product</th>
                        <th>Quantity</th>
                    </tr>
                    <tr>
                        <td>
                            <label><input type="checkbox" name="product[]" value="deluminator">Deluminator - $150</input></label>
                        </td>
                        <td>
                            <input type="number" name="quantity[]" min="0" max="10" value="0">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label><input type="checkbox" name="product[]" value="snitch">Golden Snitch - $400</input></label>
                        </td>
                        <td>
                            <input type="number" name="quantity[]" min="0" max="10" value="0">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label><input type="checkbox" name="product[]" value="cloak">Invisibility Cloak - $99.99</input></label>
                        </td>
                        <td>
                            <input type="number" name="quantity[]" min="0" max="10" value="0">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label><input type="checkbox" name="product[]" value="map">Marauder Map - $50</input></label>
                        </td>
                        <td>
                            <input type="number" name="quantity[]" min="0" max="10" value="0">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label><input type="checkbox" name="product[]" value="stone">Sorcerer's Stone - $19.95</input></label>
                        </td>
                        <td>
                            <input type="number" name="quantity[]" min="0" max="10" value="0">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label><input type="checkbox" name="product[]" value="wand">Wand - $69.99</input></label>
                        </td>
                        <td>
                            <input type="number" name="quantity[]" min="0" max="10" value="0">
                        </td>
                    </tr>
                </table>
                </p>
            </fieldset>
            <p>
                <input type="submit" value="Process Order" name="processOrder" id="processOrder">
                <input type="reset" value="Clear Your Order" name="resetform" id="resetform">
            </p>
        </form>
    </body>
</html>

