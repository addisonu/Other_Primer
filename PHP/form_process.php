<html>
<head> <title>Loan Payment Calculation</title></head>
<body>
<?php

$amount = $_GET['amount'];
$rate = $_GET['rate'];
$term = $_GET['term'];
$monthly_rate = $rate/1200;
$payment = $amount*$monthly_rate*(pow(1 + $monthly_rate, $term))/(pow(1 + $monthly_rate, $term) - 1);

print "<p> Amount: $amount </p>";
print "<p> Annual Interest Rate: $rate </p>";
print "<p> Number of months: $term </p>";
printf("Loan Payment: %.2f", $payment);
?>


</body>


</html>
