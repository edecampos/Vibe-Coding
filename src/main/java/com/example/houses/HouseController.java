package com.example.houses;

import com.example.houses.model.House;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/houses")
public class HouseController {
    private final HouseService houseService;
    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping(value = "/cheapest", produces = MediaType.TEXT_HTML_VALUE)
    public String getCheapestHousesAsTable(
            @RequestParam(name = "address", required = true) String address,
            @RequestParam(name = "radius", required = true) int radius
    ) {
        List<House> houses = houseService.getTop10CheapestPerSqFt(address, radius);
        String houseBackgroundUrl = "/images/360_F_626678236_JjyUU8BR04yZ5IGgQMtFlb9aSgAE7iB7.jpg";

        StringBuilder sb = new StringBuilder();
        sb.append("<html><head><title>Cheapest Houses</title>");
        sb.append("<meta name='viewport' content='width=device-width,initial-scale=1'/>");
        sb.append("<style>");
        sb.append(".page-section { max-width: 1200px; margin: 0 auto; }");
        sb.append("#results-section { background: url('" + houseBackgroundUrl + "') no-repeat center center; background-size: cover; border-radius:12px; box-shadow:0 4px 32px rgba(0,0,0,0.10); padding:36px 26px; position:relative; width: 100%; }");
        sb.append(".results-overlay { position:absolute;top:0;left:0;width:100%;height:100%;background:rgba(255,255,255,0.84);border-radius:12px;pointer-events:none;z-index:0; }");
        sb.append(".results-content { position:relative;z-index:1;width:100%; }");
        sb.append(".results-table { width:100%; table-layout:auto; border-collapse:collapse;background:rgba(255,255,255,0.93);border-radius:10px;box-shadow:0 2px 14px rgba(0,0,0,0.07);margin-top:20px; }");
        sb.append(".results-table th, .results-table td { padding:16px 22px; text-align:left; border-bottom:1px solid #eee; font-size:1.09rem; word-break:break-word; }");
        sb.append(".results-table th { background:#f6f7fa; font-weight:700; font-size:1.13rem; white-space:nowrap; }");
        sb.append(".results-table tr:last-child td { border-bottom:none; }");
        sb.append("@media (max-width:900px) { .page-section { padding:18px 8px; max-width:98vw; } .results-table th, .results-table td { padding:8px 5px; font-size:0.96rem; } }");
        sb.append("</style>");
        sb.append("<script>");
        sb.append("function showResultsSection(){ document.getElementById('results-section').style.display = 'block'; }");
        sb.append("</script>");
        sb.append("</head><body>");
        sb.append("<div class='page-section'>");
        sb.append("<button onclick='showResultsSection()' style='display:block;margin:0 auto 30px auto;padding:14px 36px;font-size:1.2em;background:#0095ff;color:#fff;border:none;border-radius:8px;box-shadow:0 2px 10px #0057b722;cursor:pointer;'>View Top 10 Cheapest Houses</button>");
        sb.append("<div class='separator' style='width:100%;height:12px;background:linear-gradient(90deg,#3eb6e7 60%,#00c48c);border-radius:8px;margin:36px 0 24px 0;'></div>");
        // Results section (hidden by default, revealed only via button)
        sb.append("<div id='results-section' style='display:none;'>");
        sb.append("<div class='results-overlay'></div>");
        sb.append("<div class='results-content'>");
        sb.append("<h2 style='color:#0057b7;'>Top 10 Cheapest Houses per Sq. Foot</h2>");
        // NO parent div, just the table!
        sb.append("<table class='results-table'>");
        sb.append("<thead><tr>");
        sb.append("<th>Address</th>");
        sb.append("<th>Price</th>");
        sb.append("<th>Sq. Ft.</th>");
        sb.append("<th>$ / Sq.Ft.</th>");
        sb.append("</tr></thead><tbody>");
        for (House h : houses) {
            sb.append("<tr>");
            sb.append("<td>").append(h.getAddress() != null ? h.getAddress() : "").append("</td>");
            sb.append("<td>").append(h.getPrice() != null ? String.format("$%,.2f", h.getPrice()) : "").append("</td>");
            sb.append("<td>").append(h.getSquareFootage() != null ? h.getSquareFootage().intValue() : "").append("</td>");
            sb.append("<td>").append(h.getCostPerSquareFoot() != null ? String.format("$%.2f", h.getCostPerSquareFoot()) : "").append("</td>");
            sb.append("</tr>");
        }
        sb.append("</tbody></table>");
        sb.append("</div>"); // results-content
        sb.append("</div>"); // results-section
        sb.append("</div></body></html>");
        return sb.toString();
    }
}