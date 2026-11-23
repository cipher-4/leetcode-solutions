import pandas as pd

def big_countries(world: pd.DataFrame) -> pd.DataFrame:

    world = world[(world['area'] >= 3000000) | (world['population'] >= 25000000)]

    res = world[['name','population','area']]

    return res
    