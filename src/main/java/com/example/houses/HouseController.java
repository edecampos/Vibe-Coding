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
            @RequestParam(defaultValue = "5926 MARSH CIRCLE LOVELAND OH 45140") String address,
            @RequestParam(defaultValue = "100") int radius
    ) {
        List<House> houses = houseService.getTop10CheapestPerSqFt(address, radius);

        StringBuilder sb = new StringBuilder();
        sb.append("<html><head><title>Cheapest Houses</title>");
        sb.append("<style>body{font-family:sans-serif;}table{border-collapse:collapse;}th,td{border:1px solid #ccc;padding:4px 8px;}th{background:#f0f0f0;}a{color:#1a73e8;}</style>");
        sb.append("</head><body>");
        sb.append("<h2>Top 10 Cheapest Houses per Sq Ft</h2>");
        sb.append("<table>");
        sb.append("<tr>");
        sb.append("<th>Address</th>");
        sb.append("<th>Price</th>");
        sb.append("<th>Sq. Ft.</th>");
        sb.append("<th>$ / Sq.Ft.</th>");
        sb.append("</tr>");
        for (House h : houses) {
            sb.append("<tr>");
            sb.append("<td>").append(h.getAddress() != null ? h.getAddress() : "").append("</td>");
            sb.append("<td>").append(h.getPrice() != null ? String.format("$%,.2f", h.getPrice()) : "").append("</td>");
            sb.append("<td>").append(h.getSquareFootage() != null ? h.getSquareFootage().intValue() : "").append("</td>");
            sb.append("<td>").append(h.getCostPerSquareFoot() != null ? String.format("$%.2f", h.getCostPerSquareFoot()) : "").append("</td>");
            sb.append("</tr>");
        }
        sb.append("</table>");
        sb.append("</body></html>");
        return sb.toString();
    }
}