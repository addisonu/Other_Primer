#!/usr/local/bin/python3
# FILE: lab3.1.py
# DATE: Jul 12, 2014
# DESC: Function to pick winner of RPS games

#User defined Exception classes
class WrongNumberOfPlayersError(Exception): pass
class NoSuchStrategyError(Exception): pass

def __main__():

    match = [['Jim', 'R'], ['Jack', 'P']]
    bogus_match = ['Jim', 'R']
    bogus_strategy = [['Jim', 'x'], ['Jack', 'P']]

#Should print ['Jack', 'P']
    print("The winner is ", end=' ')

#A known good match
    try:
        print(rps_game_winner(match))
    except:
        print("This test should not fail")

#A known badly formed match
    try:
        rps_game_winner(bogus_match)
    except:
        print("That was a bogus match, dude: ", end="")
        print(bogus_match)

#A known bad strategy
    try:
        rps_game_winner(bogus_strategy)
    except:
        print("That was a bogus strategy, dude: ", end=' ')
        print(bogus_strategy)

def rps_game_winner(match):
    """This function determines the winner of a properly formatted RPS game.
    
    RULES of Rock-Paper-Scissors match

    Games must have two players
    Valid strategies are: R, P, and S
    R beats S
    S beats P
    P beats R
    A tie foes to the first player

    VALID INPUT: an array of 2 arrays: [['Name1, 'Strategy1], ['Name2, 'Strategy2']]
    STRATEGIES: 'RPS'"""
    outcome = ['R', 'S', 'P']

    if len(match) != 2:
        raise WrongNumberOfPlayersError('Wrong number of players!')
    if (match[0][1] or match[1][1]) not in outcome:
        raise NoSuchStrategyError('No such strategy!')

#Code to determine the winner

#First player wins
    if match[0][1] == 'R' and match[1][1] != 'P':
        return match[0]
    elif match[0][1] == 'S' and match[1][1] != 'R':
        return match[0]
    elif match[0][1] == 'P' and match[1][1] != 'S':
        return match[0]

#Second player wins
    elif match[0][1] == 'R' and match[1][1] == 'P':
        return match[1]
    elif match[0][1] == 'S' and match[1][1] == 'R':
        return match[1]
    elif match[0][1] == 'P' and match[1][1] == 'S':
        return match[1]

if __name__ == '__main__':
    __main__()
