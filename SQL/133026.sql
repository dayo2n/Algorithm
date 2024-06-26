SELECT ICECREAM.INGREDIENT_TYPE, SUM(HALF.TOTAL_ORDER) AS TOTAL_ORDER
FROM FIRST_HALF HALF JOIN ICECREAM_INFO ICECREAM
ON HALF.FLAVOR = ICECREAM.FLAVOR
GROUP BY ICECREAM.INGREDIENT_TYPE
ORDER BY TOTAL_ORDER
