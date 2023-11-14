SELECT date_format(n.sales_date, "%Y-%m-%d") AS sales_date, 
    n.product_id,
    n.user_id,
    n.sales_amount
FROM ONLINE_SALE n
WHERE MONTH(n.sales_date) = 3
UNION ALL
SELECT date_format(f.sales_date, "%Y-%m-%d") AS sales_date, 
    f.product_id,
    null AS user_id,
    f.sales_amount
FROM OFFLINE_SALE f
WHERE MONTH(f.sales_date) = 3
ORDER BY sales_date, product_id, user_id;