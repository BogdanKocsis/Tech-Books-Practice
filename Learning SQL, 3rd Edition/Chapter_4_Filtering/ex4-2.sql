SELECT payment_id
FROM payment
WHERE customer_id=5 AND NOT (amount > 6 OR date(payment_date)='2005-06-19');