<!DOCTYPE html>
<!--
Purpose:
Author:
Date:
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title>Your Cart</title>
        <link type="text/css" rel="stylesheet" href="styles/cart.css"/>
    </head>
    <body>
        <?php
        //Immediately Create the processor
        ini_set('display_errors', 1);
        ini_set('display_startup_errors', 1);
        error_reporting(E_ALL);
        require 'scripts/Processorder.php';
        $o = new Processorder();
        ?>
        <h1>Your Shopping Cart</h1>
       
        <?php
        $o->displayBody();
        ?>
    </body>
</html>
