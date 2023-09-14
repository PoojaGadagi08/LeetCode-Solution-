You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure and the arrival airports of one flight. Reconstruct the itinerary in order and return it.

All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK". If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.

For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.

 

Example 1:


Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
Output: ["JFK","MUC","LHR","SFO","SJC"]
Example 2:


Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"] but it is larger in lexical order.
 

Constraints:

1 <= tickets.length <= 300
tickets[i].length == 2
fromi.length == 3
toi.length == 3
fromi and toi consist of uppercase English letters.
fromi != toi







  class Solution {

	HashMap<String, PriorityQueue<String>> map = new HashMap<>();
	List<String> res = new LinkedList<>();

	public List<String> findItinerary(List<List<String>> tickets) {
		for (List<String> ticket : tickets) {
			// map.putIfAbsent() is to put value if key does not exist, here we setup a pq if we meet the key the first time.
			map.putIfAbsent(ticket.get(0), new PriorityQueue<>());
			// add the "destination" to pq for dfs search, in lexical order by default
			map.get(ticket.get(0)).offer(ticket.get(1));
		}
		helper("JFK");
		return res;
	}

	public void helper(String departure) {
		// If destination exists. When arriving the last departure, add it to res directly
		while (map.containsKey(departure) && !map.get(departure).isEmpty()) {
			// get the next destination, departure and iterate
			helper(map.get(departure).poll());
		}
		res.add(0, departure);
	}
}
