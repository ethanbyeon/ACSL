
Finite State Automaton (FSA): Mathematical model of computation

Regular Expression (RE): An algebraic representation of an FSA

RegEx Identities
(a*)* = a*
aa* = a*a
aa* U λ = a*
a(b U c) = ab U ac
a(ba)* = (ab)*a
(a U b)* = (a* U b*)*
(a U b)* = (a*b*)*
(a U b)* = a*(ba*)*

RegEx Patterns
| Separates alternatives. Ex: gray|grey "gray" or "grey"

* Indicates zero or more occurrences of the preceding element

? Indicates zero or one occurrences of the preceding element. Ex: colou?r -> matches both "color" and "colour"

. Wildcard = matches any character. Ex: a.b -> "a7b", "a&b", but not "abbb"

[] Matches a single character that is contained within the brackets. Ex: [abc] -> "a", "b", or "c"

[^] Matches a single character that is not contained withing the brackets

() Define a sub-expression
