SELECT o.user_id, o.product_id
FROM ONLINE_SALE o
GROUP BY o.user_id, o.product_id
HAVING COUNT(*) > 1
ORDER BY o.user_id ASC, o.product_id DESC;