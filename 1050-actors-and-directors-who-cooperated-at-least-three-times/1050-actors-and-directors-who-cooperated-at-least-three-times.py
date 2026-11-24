import pandas as pd

def actors_and_directors(actor_director: pd.DataFrame) -> pd.DataFrame:

    res = actor_director.groupby(['actor_id','director_id']).agg(
        count=('director_id','count')
    ).reset_index()

    res = res[res['count']>=3]

    return res[['actor_id','director_id']]



    