import pandas as pd

def find_customers(customers: pd.DataFrame, orders: pd.DataFrame) -> pd.DataFrame:
    
    merged = pd.merge(customers,orders, left_on='id',
    right_on ='customerId', how='left')
    
    res = merged[merged['customerId'].isnull()]

    return res[['name']].rename(columns={'name' : 'Customers'})