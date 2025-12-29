SELECT year_no, month_no, tot_sales,
    LAG(tot_sales) OVER (ORDER BY month_no) AS prev_month_tot
FROM Sales_Fact
WHERE year_no = 2020;