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

        String backgroundUrl = "/images/background.jpg"; // Place your background image here

        StringBuilder sb = new StringBuilder();
        sb.append("<html><head><title>Cheapest Houses</title>");
        sb.append("<meta name='viewport' content='width=device-width,initial-scale=1'/>");
        sb.append("<style>");
        sb.append("body{font-family:sans-serif;min-height:100vh;margin:0;padding:0;background: url('" + backgroundUrl + "') no-repeat center center fixed;background-size:cover;}");
        sb.append(".page-section{background:rgba(255,255,255,0.92);margin:40px auto;padding:30px 40px;border-radius:18px;max-width:1200px;box-shadow:0 4px 32px rgba(0,0,0,0.10);}");
        sb.append(".results-table{width:100%;border-collapse:collapse;margin-top:24px;background:#fff;border-radius:10px;overflow:hidden;box-shadow:0 2px 14px rgba(0,0,0,0.07);}");
        sb.append(".results-table th,.results-table td{padding:16px 14px;text-align:left;border-bottom:1px solid #eee;font-size:1rem;white-space:nowrap;}");
        sb.append(".results-table th{background:#f6f7fa;font-weight:bold;}");
        sb.append(".results-table tr:last-child td{border-bottom:none;}");
        sb.append("@media (max-width:900px){.page-section{padding:18px 8px;max-width:98vw;}.results-table th,.results-table td{padding:8px 5px;font-size:0.96rem;}}");
        sb.append(".table-wrapper{overflow-x:auto;}");
        sb.append("</style>");
        sb.append("</head><body>");
        sb.append("<div class='page-section'>");
        sb.append("<h2>Top 10 Cheapest Houses per Sq Ft</h2>");
        sb.append("<div class='table-wrapper'>");
        sb.append("<table class='results-table'>");
        sb.append("<thead><tr>");
        sb.append("<th>Address</th>");
        sb.append("<th>Price</th>");
        sb.append("<th>Sq. Ft.</th>");
        sb.append("<th>$ / Sq.Ft.</th>");
        sb.append("</tr></thead>");
        sb.append("<tbody>");
        for (House h : houses) {
            sb.append("<tr>");
            sb.append("<td>").append(h.getAddress() != null ? h.getAddress() : "").append("</td>");
            sb.append("<td>").append(h.getPrice() != null ? String.format("$%,.2f", h.getPrice()) : "").append("</td>");
            sb.append("<td>").append(h.getSquareFootage() != null ? h.getSquareFootage().intValue() : "").append("</td>");
            sb.append("<td>").append(h.getCostPerSquareFoot() != null ? String.format("$%.2f", h.getCostPerSquareFoot()) : "").append("</td>");
            sb.append("</tr>");
        }
        sb.append("</tbody>");
        sb.append("</table>");
        sb.append("</div>");
        sb.append("</div>");
        sb.append("</body></html>");
        return sb.toString();
    }
}