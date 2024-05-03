SELECT CATEGORY, SUM(SALES) TOTAL_SALES
FROM BOOK_SALES JOIN BOOK
ON BOOK_SALES.BOOK_ID = BOOK.BOOK_ID
WHERE TO_CHAR(SALES_DATE, 'YYYYMM') = '202201'
GROUP BY CATEGORY
ORDER BY CATEGORY