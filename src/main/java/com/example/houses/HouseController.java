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

        String backgroundUrl = "/images/background.jpg"; // Main page background
        String houseBackgroundUrl = "/images/360_F_626678236_JjyUU8BR04yZ5IGgQMtFlb9aSgAE7iB7.jpg"; // House image as results section background

        StringBuilder sb = new StringBuilder();
        sb.append("<html><head><title>Cheapest Houses</title>");
        sb.append("<meta name='viewport' content='width=device-width,initial-scale=1'/>");
        sb.append("<style>");
        sb.append("body{font-family:sans-serif;min-height:100vh;margin:0;padding:0;background: url('" + backgroundUrl + "') no-repeat center center fixed;background-size:cover;}");
        sb.append(".page-section{background:rgba(255,255,255,0.95);margin:40px auto 40px auto;padding:30px 40px;border-radius:18px;max-width:1200px;box-shadow:0 4px 32px rgba(0,0,0,0.10);}");
        sb.append(".separator{width:100%;height:12px;background:linear-gradient(90deg,#3eb6e7 60%,#00c48c);border-radius:8px;margin:36px 0 24px 0;}");
        sb.append("#results-section{background: url('" + houseBackgroundUrl + "') no-repeat center center; background-size:cover; border-radius:12px; box-shadow:0 4px 32px rgba(0,0,0,0.10); padding:36px 26px;}");
        sb.append(".results-table{width:100%;border-collapse:collapse;background:rgba(255,255,255,0.93);border-radius:10px;box-shadow:0 2px 14px rgba(0,0,0,0.07);margin-top:20px;}");
        sb.append(".results-table th,.results-table td{padding:16px 22px;text-align:left;border-bottom:1px solid #eee;font-size:1.09rem;word-break:break-word;}");
        sb.append(".results-table th{background:#f6f7fa;font-weight:700;font-size:1.13rem;}");
        sb.append(".results-table tr:last-child td{border-bottom:none;}");
        sb.append("@media (max-width:900px){.page-section{padding:18px 8px;max-width:98vw;}.results-table th,.results-table td{padding:8px 5px;font-size:0.96rem;}}");
        sb.append("</style>");
        sb.append("<script>");
        sb.append("function scrollToResults(){document.getElementById('results-section').scrollIntoView({behavior:'smooth'});}");
        sb.append("</script>");
        sb.append("</head><body>");
        sb.append("<div class='page-section'>");
        sb.append("<button onclick='scrollToResults()' style='display:block;margin:0 auto 30px auto;padding:14px 36px;font-size:1.2em;background:#0095ff;color:#fff;border:none;border-radius:8px;box-shadow:0 2px 10px #0057b722;cursor:pointer;'>View Results</button>");
        sb.append("<div class='separator'></div>");
        sb.append("<div id='results-section'>");
        sb.append("<h2 style='color:#0057b7;'>Top 10 Cheapest Houses per Sq. Foot</h2>");
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
        sb.append("</tbody></table></div></div></body></html>");
        return sb.toString();
    }
}