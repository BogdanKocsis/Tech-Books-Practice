CREATE VIEW country_payments AS
SELECT c.country,
(
    SELECT SUM(p.amount)
    FROM city AS ct
        INNER JOIN address AS a
        ON ct.city_id = a.address_id
        INNER JOIN customer AS cust
        ON a.address_id = cust.address_id
        INNER JOIN payment AS p
        ON cst.customer_id = p.customer_id
    WHERE ct.country_id = c.country_id
) AS tot_payments
FROM country AS c;