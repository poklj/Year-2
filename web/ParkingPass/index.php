<!DOCTYPE html>
<!--
Purpose: NSCC's Parking pass form
Author: Zachary Higgs
Date: 10/10/2018
-->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html charset=UTF-8">
        <link  rel="stylesheet" type="text/css" href="css/style.css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="scripts/JQmain.js"> </script>
        
        <title>NSCC Parking pass Application</title>
    </head>
    <body>
        <div>
            <img src="image/COGsLogoLarge.jpg" alt=""/>
            <h1 class='Heading'> Parking Pass Application </h1>
        </div>
        <hr>
        <form id="aaa">
            <div id="Ddate">
                <label for='Date'> Date: </label>
                <input type='date' id='Date'/>
            </div>
            <div id="Contactinfo">
                <div class="Inputs">
                    <table>
                        <caption> Contact Information: </caption>
                        <tr>
                            <th>
                                <label for="LastName">Last Name</label>
                            </th>
                            <th>
                                <label for="FirstName">First Name</label>
                            </th>
                            <th>
                                <label for="IdNum">Student/Employee #</label>
                            </th>
                        </tr>
                        <tr>
                            <td>
                                <input type="text" id="LastName"/>
                            </td>
                            <td>
                                <input type="text" id="FirstName"/>
                            </td>
                            <td>
                                <input type="text" id="IdNum"/>
                            </td>
                    </table>
                </div>
                <div id="Pass">
                    <label for="PassType"> Type of Pass:</label>
                    <input type="radio" name="PassType" value="Single" checked>Single Car
                    <input type="radio" name="PassType" value="Pool">Car Pool 
                </div>
            </div>
            
            <div id="VehicleInfo">
                
                
                <div class="Inputs">
                    <table>
                        <caption>Vehicle Information - Permits are transferrable so please provide additional vehicle details</caption>
                        <tr>
                            <th>
                            </th>
                            <th>
                                <label for="Make">Make</label>
                            </th>
                            <th>
                                <label for="Model">Model</label>
                            </th>
                            <th>
                                <label for="PlateNum">License Plate # </label>
                            </th>
                            <th>
                                <label for="Color"> Color </label>
                            </th>
                            
                        </tr>
                        
                        <tr>
                            <td>
                                1.
                            </td>
                            <td>
                                <input type="text" class="Make"/>  
                            </td>
                            <td>
                                <input type="text" class="Model"/>
                            </td>
                            <td>
                                <input type="text" class="PlateNum"/>
                            </td>
                            <td>
                                <input type="text" class="Color"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                2.
                            </td>
                            <td>
                                <input type="text" class="Make"/>  
                            </td>
                            <td>
                                <input type="text" class="Model"/>
                            </td>
                            <td>
                                <input type="text" class="PlateNum"/>
                            </td>
                            <td>
                                <input type="text" class="Color"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                3.
                            </td>
                            <td>
                                <input type="text" class="Make"/>  
                            </td>
                            <td>
                                <input type="text" class="Model"/>
                            </td>
                            <td>
                                <input type="text" class="PlateNum"/>
                            </td>
                            <td>
                                <input type="text" class="Color"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                4.
                            </td>
                            <td>
                                <input type="text" class="Make"/>  
                            </td>
                            <td>
                                <input type="text" class="Model"/>
                            </td>
                            <td>
                                <input type="text" class="PlateNum"/>
                            </td>
                            <td>
                                <input type="text" class="Color"/>
                            </td>
                        </tr>
                    </table>
                </div>
                <a href='#' id='Regulations'><b>Parking Regulations - Click to see details</b></a>
                <p id='reg'> </p>
                <input type='checkbox' id='Readit'/>
                <label for='Readit'>I have read, and agree to the <b>Parking Regulations</b> stated above</label>
                </div>  
                <div id="infoButt">
                    </br>
                    <input type="submit">
                    <button type="reset" value="Reset">Clear</button>
                </div>

        </form>
        </br>
        <form>
            <div id="Office">
                <br><hr>
                <p>For Office Use Only:</p>
                <table>
                    <tr>
                        <th>
                            <label for="ppNumber">Parking Pass Number</label>
                        </th>
                        <th>
                            <label for="Receipt">Receipt #</label>
                        </th>
                        <th>
                            <label for="DateIssued">Date Issued</label> 
                        </th>
                        <th>
                            <label for="AmountPaid">Amount Paid</label>
                        </th>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" id="ppNumber"/>
                        </td>
                        <td>
                            <input type="text" id="Receipt"/>
                        </td>
                        <td>
                            <input type="date" id="DateIssued"/>
                        </td>
                        <td>
                            <input type="text" id="AmountPaid"/>
                        </td>
                    </tr>
            </table>
            </div>
            <div id="offButt">
                <button type="submit" disabled="true">Process</button>
                <button type="reset" disabled="true"> Clear</button>
            </div>
        </form>
    </body>
</html>
