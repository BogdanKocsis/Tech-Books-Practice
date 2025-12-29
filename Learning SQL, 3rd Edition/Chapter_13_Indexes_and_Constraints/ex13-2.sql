ALTER TABLE payment
ADD INDEX purchase_index (customer_id, payment_date, amount);