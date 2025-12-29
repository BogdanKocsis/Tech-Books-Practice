SELECT c.first_name, c.last_name, SUM(p.amount)
FROM customer AS c
    LEFT OUTER JOIN payment AS p
    ON c.customer_id = p.customer_id
GROUP BY c.customer_id;