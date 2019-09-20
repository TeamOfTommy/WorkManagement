package cn.tommyyang.workmanagement.service.impl;

import cn.tommyyang.slf4j4json.Logger;
import cn.tommyyang.slf4j4json.LoggerFactory;
import cn.tommyyang.workmanagement.dao.ICompetitionDao;
import cn.tommyyang.workmanagement.model.Competition;
import cn.tommyyang.workmanagement.service.ICompetitionService;
import cn.tommyyang.workmanagement.utils.Constants;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

/**
 * @Author : TommyYang
 * @Time : 2019-09-16 17:37
 * @Software: IntelliJ IDEA
 * @File : CompetitionServiceImpl.java
 */
@Service
public class CompetitionServiceImpl implements ICompetitionService {

    private static final Logger LOG = LoggerFactory.getLogger(CompetitionServiceImpl.class);

    @Autowired
    @Qualifier("competitionDao")
    private ICompetitionDao competitionDao;

    @Override
    public String getJson(int page, int rows, String nationality, String sex, String division, String group) {
        try {
            List<Competition> competitions = this.get(nationality, sex, division, group);
            return listToJson(competitions, page, rows);
        } catch (Exception e) {
            LOG.info().strField("event", "get-competition-json").strField("error", e.getMessage())
                    .exception("\nexception:\n", e).log();
        }

        return "";
    }

    @Override
    public File exportData(String nationality, String sex, String division, String group) {
        List<Competition> competitions = this.get(nationality, sex, division, group);
        String filePath = String.format("%s/%s.xlsx", Constants.FILE_DIR, UUID.randomUUID());
        try {
            File file = new File(filePath);
            file.getParentFile().mkdirs();
            file.createNewFile();

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("项目数据");

            Row head = sheet.createRow(0);
            String[] header = getHeader();
            XSSFCellStyle cs1 = workbook.createCellStyle();
            XSSFFont font = workbook.createFont();
            font.setBold(true);
            cs1.setFont(font);

            XSSFCellStyle cs2 = workbook.createCellStyle();
            XSSFDataFormat dataFormat = workbook.createDataFormat();
            cs2.setDataFormat(dataFormat.getFormat("#,##0.000000"));

            IntStream.range(0, header.length).forEach(index -> {
                Cell cell = head.createCell(index);
                cell.setCellStyle(cs1);
                cell.setCellValue(header[index]);
            });

            IntStream.rangeClosed(1, competitions.size()).forEach(
                    index -> {
                        Row row = sheet.createRow(index);
                        Competition c = competitions.get(index - 1);
                        int cellNum = 0;
                        row.createCell(cellNum++).setCellValue(c.getName());
                        row.createCell(cellNum++).setCellValue(c.getBirth());
                        row.createCell(cellNum++).setCellValue(c.getHeadImg());
                        row.createCell(cellNum++).setCellValue(c.getNationality());
                        row.createCell(cellNum++).setCellValue(c.getSex());
                        row.createCell(cellNum++).setCellValue(c.getLevel());
                        row.createCell(cellNum++).setCellValue(c.getProject());
                        row.createCell(cellNum++).setCellValue(c.getOrg());
                        row.createCell(cellNum++).setCellValue(c.getMusicUrl());
                        row.createCell(cellNum++).setCellValue(c.getDivision());
                        row.createCell(cellNum++).setCellValue(c.getGroup());
                        row.createCell(cellNum++).setCellValue(c.getInstrument());
                        row.createCell(cellNum++).setCellValue(c.getAddress());
                        row.createCell(cellNum++).setCellValue(c.getPhone());
                        row.createCell(cellNum++).setCellValue(c.getTeacher());
                        row.createCell(cellNum++).setCellValue(c.getMobile());
                        row.createCell(cellNum++).setCellValue(c.getType());
                        row.createCell(cellNum++).setCellValue(c.getOrderNo());
                        row.createCell(cellNum++).setCellValue(c.getPid());
                        Cell cell = row.createCell(cellNum++);
                        cell.setCellStyle(cs2);
                        cell.setCellValue(c.getOrderAmount());
                        row.createCell(cellNum++).setCellValue(c.getPayStatus());
                        row.createCell(cellNum++).setCellValue(timeStampToDateStr(c.getCreateTime()));
                    }
            );


            FileOutputStream outputStream = new FileOutputStream(file);
            workbook.write(outputStream);
            workbook.close();

            return file;
        } catch (Exception e) {
            LOG.info().strField("event", "export-competition-data").strField("error", e.getMessage())
                    .exception("\nexception:\n", e).log();
        }

        return null;
    }

    private List<Competition> get(String nationality, String sex, String division, String group) {
        List<Competition> competitions;
        if (nationality.equals("all") && sex.equals("all")
                && division.equals("") && group.equals("")) {
            competitions = this.competitionDao.get();
        } else {
            Competition competition = new Competition();
            competition.setNationality(nationality);
            competition.setSex(sex);
            competition.setDivision(division);
            competition.setGroup(group);
            competitions = this.competitionDao.get(competition);
        }
        return competitions;
    }

    private String listToJson(List<Competition> competitions, int page, int rows) {
        int total = competitions.size();
        int start = (page - 1) * rows;
        int end = page * rows;
        int currentEnd = end <= total ? end : total;

        StringBuilder sBuilder = new StringBuilder("{");
        sBuilder.append("\"total\":").append(String.format("\"%d\",", total))
                .append("\"rows\":[");
        IntStream.range(start, currentEnd).forEach(index -> {
            Competition c = competitions.get(index);
            String timeStr = timeStampToDateStr(c.getCreateTime());
            StringBuilder builder = new StringBuilder();
            builder.append("{\"id\":").append(String.format("\"%d\"", c.getId())).append(",")
                    .append("\"name\":").append(String.format("\"%s\"", c.getName())).append(",")
                    .append("\"birth\":").append(String.format("\"%s\"", c.getBirth())).append(",")
                    .append("\"headimg\":").append(String.format("\"%s\"", c.getHeadImg())).append(",")
                    .append("\"nationality\":").append(String.format("\"%s\"", c.getNationality())).append(",")
                    .append("\"sex\":").append(String.format("\"%s\"", c.getSex())).append(",")
                    .append("\"level\":").append(String.format("\"%s\"", c.getLevel())).append(",")
                    .append("\"project\":").append(String.format("\"%s\"", c.getProject())).append(",")
                    .append("\"org\":").append(String.format("\"%s\"", c.getOrg())).append(",")
                    .append("\"musicurl\":").append(String.format("\"%s\"", c.getMusicUrl())).append(",")
                    .append("\"division\":").append(String.format("\"%s\"", c.getDivision())).append(",")
                    .append("\"group\":").append(String.format("\"%s\"", c.getGroup())).append(",")
                    .append("\"instrument\":").append(String.format("\"%s\"", c.getInstrument())).append(",")
                    .append("\"address\":").append(String.format("\"%s\"", c.getAddress())).append(",")
                    .append("\"phone\":").append(String.format("\"%s\"", c.getPhone())).append(",")
                    .append("\"teacher\":").append(String.format("\"%s\"", c.getTeacher())).append(",")
                    .append("\"mobile\":").append(String.format("\"%s\"", c.getMobile())).append(",")
                    .append("\"orderno\":").append(String.format("\"%s\"", c.getOrderNo())).append(",")
                    .append("\"pid\":").append(String.format("\"%d\"", c.getPid())).append(",")
                    .append("\"orderamount\":").append(String.format("\"%f\"", c.getOrderAmount())).append(",")
                    .append("\"paystatus\":").append(String.format("\"%d\"", c.getPayStatus())).append(",")
                    .append("\"createtime\":").append(String.format("\"%s\"", timeStr)).append("},");
            sBuilder.append(builder.toString());

        });

        String json;
        if(total > 0) {
            json = sBuilder.substring(0, sBuilder.length() - 1);
        } else {
            json = sBuilder.toString();
        }

        return json + "]}";
    }

    private static String[] getHeader() {
        return new String[]{
                "姓名", "出生日期", "头像", "国籍", "性别", "项目水平", "参赛项目", "选送单位",
                "作品音乐路径", "赛区", "分组", "使用的乐器", "联系地址", "联系电话",
                "指导老师", "指导老师电话", "类型", "订单号", "报名类型", "订单金额",
                "订单状态", "创建时间"
        };
    }

    private String timeStampToDateStr(String timeStamp) {
        Integer time = Integer.parseInt(timeStamp);
        Timestamp ts = new Timestamp((long)time * 1000);
        Instant instant = ts.toInstant();
        String timeStr = instant.toString().substring(0, 10);

        return timeStr;
    }
}
