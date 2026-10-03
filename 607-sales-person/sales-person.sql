select name 
     from salesperson
     where sales_id not in(
        select e.sales_id 
        from orders e
        join company c
        on e.com_id=c.com_id
        where c.name='RED'
     );