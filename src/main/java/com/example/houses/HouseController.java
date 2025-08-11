// ... within your getCheapestHousesAsTable method ...
sb.append("<style>");
sb.append(".results-content { border: 3px solid #e53935; border-radius: 10px; padding: 18px; background: transparent; }");
sb.append(".results-table { width: 100%; border-collapse: collapse; background: rgba(255,255,255,0.93); border-radius:10px; box-shadow:0 2px 14px rgba(0,0,0,0.07); margin-top:20px; }");
sb.append(".results-table th, .results-table td { padding:16px 22px; text-align:left; border-bottom:1px solid #eee; font-size:1.09rem; word-break:break-word; }");
sb.append(".results-table th { background:#f6f7fa; font-weight:700; font-size:1.13rem; }");
sb.append(".results-table tr:last-child td { border-bottom:none; }");
sb.append("@media (max-width:900px) { .page-section { padding:18px 8px; max-width:98vw; } .results-table th, .results-table td { padding:8px 5px; font-size:0.96rem; } }");
sb.append("</style>");
// ...
sb.append("<div class='results-content'>");
sb.append("<h2 style='color:#0057b7;'>Top 10 Cheapest Houses per Sq. Foot</h2>");
sb.append("<table class='results-table'>");
// table rows
sb.append("</table>");
sb.append("</div>");