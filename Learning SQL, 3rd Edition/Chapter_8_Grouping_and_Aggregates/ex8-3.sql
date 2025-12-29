SELECT customer_id, count(*), sum(amount)
FROM payment
GROUP BY customer_id
HAVING count(*) >=40;