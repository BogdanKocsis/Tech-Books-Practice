SELECT year_no, month_no, tot_sales,
    RANK(tot_sales) OVER(PARTITION BY year_no ORDER BY tot_sales DESC) AS sales_rank
FROM Sales_Fact;