package cn.tommyyang.workmanagement.controller.competition;

import cn.tommyyang.slf4j4json.Logger;
import cn.tommyyang.slf4j4json.LoggerFactory;
import cn.tommyyang.workmanagement.controller.BaseController;
import cn.tommyyang.workmanagement.service.ICompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author : TommyYang
 * @Time : 2019-09-15 15:54
 * @Software: IntelliJ IDEA
 * @File : CompetitionController.java
 */
@Controller
@RequestMapping("competition")
public class CompetitionController extends BaseController {

    private static final Logger LOG = LoggerFactory.getLogger(CompetitionController.class);

    @Autowired
    private ICompetitionService competitionService;

    @RequestMapping(value = "/manage.do", method = RequestMethod.GET)
    public String manage(HttpServletRequest request, HttpServletResponse response) {
        return renderString(response, "competitionmanagement");
    }

    @RequestMapping(value = "/getdata.do", method = RequestMethod.POST)
    @ResponseBody
    public void getData(HttpServletRequest request, HttpServletResponse response,
                        @RequestParam(value = "nationality") String nationality,
                        @RequestParam(value = "sex") String sex,
                        @RequestParam(value = "division") String division,
                        @RequestParam(value = "group") String group,
                        @RequestParam(value = "type") int type,
                        @RequestParam(value = "page") int page,
                        @RequestParam(value = "rows") int rows) {
        try {
            if (type == 1 && page > 1) {
                page = 1;
            }
            this.writeResponseContent(response, competitionService.getJson(page, rows, nationality, sex, division, group));
        } catch (IOException e) {
            LOG.info().strField("event", "get-competition-data").strField("error", e.getMessage())
                    .exception("\nexception:\n", e).log();
        }
    }

    @RequestMapping(value = "/export.do", method = RequestMethod.POST)
    public String manage(HttpServletRequest request, HttpServletResponse response,
                         @RequestParam(value = "nationality") String nationality,
                         @RequestParam(value = "sex") String sex,
                         @RequestParam(value = "division") String division,
                         @RequestParam(value = "group") String group) {

        try {
            this.download(response, competitionService.exportData(nationality, sex, division, group), "application/x-excel");
        } catch (IOException e) {
            LOG.info().strField("event", "download-competition-file").strField("error", e.getMessage())
                    .exception("\nexception:\n", e).log();
        }

        return null;
    }
}
