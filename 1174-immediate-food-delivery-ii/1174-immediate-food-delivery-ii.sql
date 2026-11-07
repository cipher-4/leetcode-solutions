# Write your MySQL query statement below

select 
round((count(case when order_date = customer_pref_delivery_date then 1 end)*100.0)/count(*),2)
as immediate_percentage from Delivery d
join(select customer_id, min(order_date) as first_order from Delivery 
group by customer_id) as f 
on d.customer_id = f.customer_id
and d.order_date = f.first_order;
