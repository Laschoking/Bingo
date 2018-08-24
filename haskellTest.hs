module haskellTest
fac :: Int -> Int
fac 0 = 1
fac n = fac(n - 1) * n

