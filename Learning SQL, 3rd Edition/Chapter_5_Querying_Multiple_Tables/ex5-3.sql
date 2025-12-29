SELECT a1.address, a2.address, a1.city_id
	FROM address a1
	INNER JOIN address a2
ON a1.city_id = a2.city_id
	AND a1.address < a2.address;
-- the second condition in the WHERE clause filters so that we don't have (A,B) and (B,A) in the results