--       date: 2022-09-27
--      title: Push Dominoes
--        url: https://leetcode.com/problems/push-dominoes/
-- difficulty: medium

pushDominoes :: [Char] -> [Char]
pushDominoes = stitchGroups . map transformGroup . splitGroups . decorate

decorate :: [Char] -> [Char]
decorate x = "L" ++ x ++ "R"

splitGroups :: [Char] -> [[Char]]
splitGroups (x:xs) = splitGroups_ [x] xs
  where
    splitGroups_ acc [] = [acc]
    splitGroups_ acc (x:xs) =
      if (x /= '.')
        then (acc ++ [x]) : splitGroups_ [x] xs
        else splitGroups_ (acc ++ [x]) xs

transformGroup :: [Char] -> [Char]
transformGroup group =
  case (head group, last group) of
    ('L', 'R') -> group
    ('L', 'L') -> take len $ repeat 'L'
    ('R', 'R') -> take len $ repeat 'R'
    ('R', 'L') ->
      take (len `div` 2) (repeat 'R') ++
      (if (odd len) then "." else "") ++
      take (len `div` 2) (repeat 'L')
  where
    len = length group

stitchGroups :: [[Char]] -> [Char]
stitchGroups = init . concatMap tail
