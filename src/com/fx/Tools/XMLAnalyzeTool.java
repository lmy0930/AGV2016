package com.fx.Tools;

import com.fx.Map.MapDate;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shinelon on 2016/11/29.
 */
public class XMLAnalyzeTool {
    public static List<MapDate> MapXMLAnalyze(String url) throws JDOMException, IOException {
        List<MapDate> list = new ArrayList<MapDate>();
        SAXBuilder reader = new SAXBuilder();
        File file = new File(url);
        Document document = reader.build(file);
        Element root = document.getRootElement();
        List<Element> bodys = root.getChildren("DataX");
        for (Element ele : bodys) {
            List<Element> childElements = ele.getChildren("DataY");
            MapDate mapdate = new MapDate();
            for (Element elec : childElements) {
                mapdate.addEle(elec.getText());
            }
            list.add(mapdate);

        }
        return list;
    }

}
