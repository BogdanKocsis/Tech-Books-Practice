SELECT DISTINCT customer_id
FROM rental
WHERE date(rental_date) = '2005-07-05';