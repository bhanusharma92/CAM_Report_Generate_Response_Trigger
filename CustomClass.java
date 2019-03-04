// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CustomClass.java

package com.newgen.omniflow;

import com.newgen.mvcbeans.model.*;
import com.newgen.mvcbeans.model.wfobjects.*;
//import com.newgen.omni.jts.client.NGOEjbApi;
//import com.newgen.omni.jts.client.WFSEjbApi;
//import com.newgen.omni.wf.util.app.NGEjbClient;
//import com.newgen.omni.wf.util.excp.NGException;
import com.newgen.wfdesktop.session.WFSession;
import com.newgen.wfdesktop.xmlapi.WFCallBroker;
import com.newgen.wfdesktop.xmlapi.WFXmlList;
import com.newgen.wfdesktop.xmlapi.WFXmlWrapper;

import java.io.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class CustomClass
{

    WFSession wfsession = null;

    public CustomClass()
    {

    }

    public String savePreHook(WorkdeskModel workdeskmodel, String s)
    {
        WiAttribHashMap wiattribhashmap = workdeskmodel.getAttributeMap();
        return "true";
    }

    public String customMethod(WorkdeskModel workdeskmodel)
    {
        WiAttribHashMap wiattribhashmap = workdeskmodel.getAttributeMap();
        return "true";
    }

    public String importDocPreHook(WorkdeskModel workdeskmodel, File file, String s, String s1)
    {
        WiAttribHashMap wiattribhashmap = workdeskmodel.getAttributeMap();
        return "true";
    }

    public String introDonePreHook(WiSessionBean wisessionbean)
    {
        return "true";
    }

    public void introDonePostHook(WiSessionBean wisessionbean)
    {
    }

    public String wfGeneralCustomParam(WFSession wfsession1, String s)
    {

        return "";
    }

    public boolean isTimeZoneLocalizationApplicable(String s, String s1, String s2)
    {
        return false;
    }

    public String importDocPostHook(WorkdeskModel workdeskmodel, WFDocument wfdocument)
    {
        WiAttribHashMap wiattribhashmap = workdeskmodel.getAttributeMap();
        return "true";
    }

    public boolean replaceGRTemplateArgs(File file, File file1, String s, WorkdeskModel workdeskmodel)
    {
        return false;
    }

    public boolean convertToPdfHook(File file, WorkdeskModel workdeskmodel)
    {
        String s = file.getAbsolutePath();
        String s1 = (new StringBuilder()).append(s.substring(0, s.lastIndexOf('.'))).append(".pdf").toString();
        return false;
    }

    public String getGenerateResponseCustomData(WorkdeskModel workdeskmodel)
    {
        // String output=queryFromDb(workdeskmodel);
        /*String output=queryFromDbCon();
        String result="";
        result+= "&<lov_name>&"+output+"@10";
        System.out.println("Result is >>>>"+result);
        return result;*/
        String transactionId = workdeskmodel.getWorkitem().getProcessInstanceId();
        WFCallBroker.generateLog("GenResp", "transactionId: " + transactionId);
        System.out.println( "transactionId: " + transactionId);
        CustomClassData customClassData = new CustomClassData(transactionId);
        customClassData.setLinearFields();

        StringBuffer resultStrBuffer = new StringBuffer("");
        resultStrBuffer.append("&<cam_no>&").append(customClassData.cam_no).append("@10");
        resultStrBuffer.append("&<currentdate>&").append(customClassData.currentdate).append("@10");
        resultStrBuffer.append("&<camtype>&").append(customClassData.camtype).append("@10");
        resultStrBuffer.append("&<classification>&").append(customClassData.classification).append("@10");
        resultStrBuffer.append("&<business_model_new>&").append(customClassData.business_model_new).append("@10");
        resultStrBuffer.append("&<assetfinancecategory>&").append(customClassData.assetfinancecategory).append("@10");
        resultStrBuffer.append("&<sector>&").append(customClassData.sector).append("@10");
        resultStrBuffer.append("&<product>&").append(customClassData.product).append("@10");
        resultStrBuffer.append("&<subsector>&").append(customClassData.subsector).append("@10");
        resultStrBuffer.append("&<subsectorcode>&").append(customClassData.subsectorcode).append("@10");
        resultStrBuffer.append("&<customercategory>&").append(customClassData.customercategory).append("@10");
        resultStrBuffer.append("&<region>&").append(customClassData.region).append("@10");
        resultStrBuffer.append("&<geographiccategory>&").append(customClassData.geographiccategory).append("@10");
        resultStrBuffer.append("&<branch>&").append(customClassData.branch).append("@10");
        resultStrBuffer.append("&<negativearea>&").append(customClassData.negativearea).append("@10");
        resultStrBuffer.append("&<distance_frm_srei_office>&").append(customClassData.distance_frm_srei_office).append("@10");
        resultStrBuffer.append("&<cautionprofile>&").append(customClassData.cautionprofile).append("@10");
        resultStrBuffer.append("&<rmname>&").append(customClassData.rmname).append("@10");
        resultStrBuffer.append("&<collectionofficer>&").append(customClassData.collectionofficer).append("@10");
        resultStrBuffer.append("&<classofcontractor>&").append(customClassData.classofcontractor).append("@10");

        // applicant, co-applicant and guarantor details
        resultStrBuffer.append("&<partynameApplicant>&").append(customClassData.partynameApplicant).append("@10");
        resultStrBuffer.append("&<relationshipApplicant>&").append(customClassData.relationshipApplicant).append("@10");
        resultStrBuffer.append("&<addressApplicant>&").append(customClassData.addressApplicant).append("@10");
        resultStrBuffer.append("&<mobilenumApplicant>&").append(customClassData.mobilenumApplicant).append("@10");
        resultStrBuffer.append("&<emailaddApplicant>&").append(customClassData.emailaddApplicant).append("@10");
        resultStrBuffer.append("&<websiteApplicant>&").append(customClassData.websiteApplicant).append("@10");
        resultStrBuffer.append("&<constitutionApplicant>&").append(customClassData.constitutionApplicant).append("@10");
        resultStrBuffer.append("&<dobApplicant>&").append(customClassData.dobApplicant).append("@10");
        resultStrBuffer.append("&<bussexpApplicant>&").append(customClassData.bussexpApplicant).append("@10");
        resultStrBuffer.append("&<sreiexistingcustomerApplicant>&").append(customClassData.sreiexistingcustomerApplicant).append("@10");
        resultStrBuffer.append("&<cibilscoreApplicant>&").append(customClassData.cibilscoreApplicant).append("@10");
        resultStrBuffer.append("&<experianscoreApplicant>&").append(customClassData.experianscoreApplicant).append("@10");
        resultStrBuffer.append("&<equifaxscoreApplicant>&").append(customClassData.equifaxscoreApplicant).append("@10");
        resultStrBuffer.append("&<crifscoreApplicant>&").append(customClassData.crifscoreApplicant).append("@10");
        resultStrBuffer.append("&<cibilscorecommentsApplicant>&").append(customClassData.cibilscorecommentsApplicant).append("@10");
        resultStrBuffer.append("&<resifinumberApplicant>&").append(customClassData.resifinumberApplicant).append("@10");
        resultStrBuffer.append("&<resificommentsApplicant>&").append(customClassData.resificommentsApplicant).append("@10");
        resultStrBuffer.append("&<officefinumberApplicant>&").append(customClassData.officefinumberApplicant).append("@10");
        resultStrBuffer.append("&<officeficommentsApplicant>&").append(customClassData.officeficommentsApplicant).append("@10");
        resultStrBuffer.append("&<residencestabilityApplicant>&").append(customClassData.residencestabilityApplicant).append("@10");
        resultStrBuffer.append("&<residencestatusApplicant>&").append(customClassData.residencestatusApplicant).append("@10");
        resultStrBuffer.append("&<tvrdecisionApplicant>&").append(customClassData.tvrdecisionApplicant).append("@10");
        resultStrBuffer.append("&<tvrcommentsApplicant>&").append(customClassData.tvrcommentsApplicant).append("@10");
        resultStrBuffer.append("&<pslcategoryApplicant>&").append(customClassData.pslcategoryApplicant).append("@10");
        resultStrBuffer.append("&<riskcategoryofcustomerApplicant>&").append(customClassData.riskcategoryofcustomerApplicant).append("@10");
        resultStrBuffer.append("&<riskcategorycustuserApplicant>&").append(customClassData.riskcategorycustuserApplicant).append("@10");
        resultStrBuffer.append("&<riskgradeApplicant>&").append(customClassData.riskgradeApplicant).append("@10");
        resultStrBuffer.append("&<agreewithratingsApplicant>&").append(customClassData.agreewithratingsApplicant).append("@10");
        resultStrBuffer.append("&<assetexperienceApplicant>&").append(customClassData.assetexperienceApplicant).append("@10");
        resultStrBuffer.append("&<fleetsizeApplicant>&").append(customClassData.fleetsizeApplicant).append("@10");
        resultStrBuffer.append("&<ratingagencyApplicant>&").append(customClassData.ratingagencyApplicant).append("@10");
        resultStrBuffer.append("&<Creditenhancement1Applicant>&").append(customClassData.Creditenhancement1Applicant).append("@10");
        resultStrBuffer.append("&<Creditenhancement2Applicant>&").append(customClassData.Creditenhancement2Applicant).append("@10");
        resultStrBuffer.append("&<lengthofassociation_pdpApplicant>&").append(customClassData.lengthofassociation_pdpApplicant).append("@10");

        resultStrBuffer.append("&<partynameCoApplicant>&").append(customClassData.partynameCoApplicant).append("@10");
        resultStrBuffer.append("&<relationshipCoApplicant>&").append(customClassData.relationshipCoApplicant).append("@10");
        resultStrBuffer.append("&<addressCoApplicant>&").append(customClassData.addressCoApplicant).append("@10");
        resultStrBuffer.append("&<mobilenumCoApplicant>&").append(customClassData.mobilenumCoApplicant).append("@10");
        resultStrBuffer.append("&<emailaddCoApplicant>&").append(customClassData.emailaddCoApplicant).append("@10");
        resultStrBuffer.append("&<websiteCoApplicant>&").append(customClassData.websiteCoApplicant).append("@10");
        resultStrBuffer.append("&<constitutionCoApplicant>&").append(customClassData.constitutionCoApplicant).append("@10");
        resultStrBuffer.append("&<dobCoApplicant>&").append(customClassData.dobCoApplicant).append("@10");
        resultStrBuffer.append("&<bussexpCoApplicant>&").append(customClassData.bussexpCoApplicant).append("@10");
        resultStrBuffer.append("&<sreiexistingcustomerCoApplicant>&").append(customClassData.sreiexistingcustomerCoApplicant).append("@10");
        resultStrBuffer.append("&<cibilscoreCoApplicant>&").append(customClassData.cibilscoreCoApplicant).append("@10");
        resultStrBuffer.append("&<experianscoreCoApplicant>&").append(customClassData.experianscoreCoApplicant).append("@10");
        resultStrBuffer.append("&<equifaxscoreCoApplicant>&").append(customClassData.equifaxscoreCoApplicant).append("@10");
        resultStrBuffer.append("&<crifscoreCoApplicant>&").append(customClassData.crifscoreCoApplicant).append("@10");
        resultStrBuffer.append("&<cibilscorecommentsCoApplicant>&").append(customClassData.cibilscorecommentsCoApplicant).append("@10");
        resultStrBuffer.append("&<resifinumberCoApplicant>&").append(customClassData.resifinumberCoApplicant).append("@10");
        resultStrBuffer.append("&<resificommentsCoApplicant>&").append(customClassData.resificommentsCoApplicant).append("@10");
        resultStrBuffer.append("&<officefinumberCoApplicant>&").append(customClassData.officefinumberCoApplicant).append("@10");
        resultStrBuffer.append("&<officeficommentsCoApplicant>&").append(customClassData.officeficommentsCoApplicant).append("@10");
        resultStrBuffer.append("&<residencestabilityCoApplicant>&").append(customClassData.residencestabilityCoApplicant).append("@10");
        resultStrBuffer.append("&<residencestatusCoApplicant>&").append(customClassData.residencestatusCoApplicant).append("@10");
        resultStrBuffer.append("&<tvrdecisionCoApplicant>&").append(customClassData.tvrdecisionCoApplicant).append("@10");
        resultStrBuffer.append("&<tvrcommentsCoApplicant>&").append(customClassData.tvrcommentsCoApplicant).append("@10");
        resultStrBuffer.append("&<pslcategoryCoApplicant>&").append(customClassData.pslcategoryCoApplicant).append("@10");

        resultStrBuffer.append("&<partynameGuarantor>&").append(customClassData.partynameGuarantor).append("@10");
        resultStrBuffer.append("&<relationshiptypeGuarantor>&").append(customClassData.relationshiptypeGuarantor).append("@10");
        resultStrBuffer.append("&<addressGuarantor>&").append(customClassData.addressGuarantor).append("@10");
        resultStrBuffer.append("&<mobilenumGuarantor>&").append(customClassData.mobilenumGuarantor).append("@10");
        resultStrBuffer.append("&<relationshipGuarantor>&").append(customClassData.relationshipGuarantor).append("@10");
        resultStrBuffer.append("&<constitutionGuarantor>&").append(customClassData.constitutionGuarantor).append("@10");
        resultStrBuffer.append("&<dobGuarantor>&").append(customClassData.dobGuarantor).append("@10");
        resultStrBuffer.append("&<bussexpGuarantor>&").append(customClassData.bussexpGuarantor).append("@10");
        resultStrBuffer.append("&<sreiexistingcustomerGuarantor>&").append(customClassData.sreiexistingcustomerGuarantor).append("@10");
        resultStrBuffer.append("&<cibilscoreGuarantor>&").append(customClassData.cibilscoreGuarantor).append("@10");
        resultStrBuffer.append("&<experianscoreGuarantor>&").append(customClassData.experianscoreGuarantor).append("@10");
        resultStrBuffer.append("&<equifaxscoreGuarantor>&").append(customClassData.equifaxscoreGuarantor).append("@10");
        resultStrBuffer.append("&<crifscoreGuarantor>&").append(customClassData.crifscoreGuarantor).append("@10");
        resultStrBuffer.append("&<cibilscorecommentsGuarantor>&").append(customClassData.cibilscorecommentsGuarantor).append("@10");
        resultStrBuffer.append("&<resifinumberGuarantor>&").append(customClassData.resifinumberGuarantor).append("@10");
        resultStrBuffer.append("&<resificommentsGuarantor>&").append(customClassData.resificommentsGuarantor).append("@10");
        resultStrBuffer.append("&<officefinumberGuarantor>&").append(customClassData.officefinumberGuarantor).append("@10");
        resultStrBuffer.append("&<officeficommentsGuarantor>&").append(customClassData.officeficommentsGuarantor).append("@10");

        // Query10 values
        resultStrBuffer.append("&<natureofwork>&").append(customClassData.natureofwork).append("@10");
        resultStrBuffer.append("&<businessbackground>&").append(customClassData.businessbackground).append("@10");
        resultStrBuffer.append("&<gurantorbackground>&").append(customClassData.gurantorbackground).append("@10");
        resultStrBuffer.append("&<majorprincipal>&").append(customClassData.majorprincipal).append("@10");
        resultStrBuffer.append("&<proposedassets>&").append(customClassData.proposedassets).append("@10");
        resultStrBuffer.append("&<existingassetscomment>&").append(customClassData.existingassetscomment).append("@10");
        resultStrBuffer.append("&<coapplicantprofile>&").append(customClassData.coapplicantprofile).append("@10");
        resultStrBuffer.append("&<group_profile>&").append(customClassData.group_profile).append("@10");
        resultStrBuffer.append("&<assethistory>&").append(customClassData.assethistory).append("@10");
        resultStrBuffer.append("&<quippovaluationreport>&").append(customClassData.quippovaluationreport).append("@10");
        resultStrBuffer.append("&<existingexposurecomment>&").append(customClassData.existingexposurecomment).append("@10");
        resultStrBuffer.append("&<existingexposureconduct>&").append(customClassData.existingexposureconduct).append("@10");
        resultStrBuffer.append("&<viabilitycalculation>&").append(customClassData.viabilitycalculation).append("@10");
        resultStrBuffer.append("&<foirresult>&").append(customClassData.foirresult).append("@10");
        resultStrBuffer.append("&<foir>&").append(customClassData.foir).append("@10");
        resultStrBuffer.append("&<inhandcontractcomment>&").append(customClassData.inhandcontractcomment).append("@10");
        resultStrBuffer.append("&<commentfinancialhighlights>&").append(customClassData.commentfinancialhighlights).append("@10");
        resultStrBuffer.append("&<particulars>&").append(customClassData.particulars).append("@10");
        resultStrBuffer.append("&<dscr>&").append(customClassData.dscr).append("@10");
        resultStrBuffer.append("&<acr>&").append(customClassData.acr).append("@10");
        resultStrBuffer.append("&<externalliabilitycomment>&").append(customClassData.externalliabilitycomment).append("@10");
        resultStrBuffer.append("&<periodfrom>&").append(customClassData.periodfrom).append("@10");
        resultStrBuffer.append("&<periodto>&").append(customClassData.periodto).append("@10");
        resultStrBuffer.append("&<totalbilling>&").append(customClassData.totalbilling).append("@10");
        resultStrBuffer.append("&<totalpaymentreceived>&").append(customClassData.totalpaymentreceived).append("@10");
        resultStrBuffer.append("&<currentyearworking>&").append(customClassData.currentyearworking).append("@10");
        resultStrBuffer.append("&<portfoliosnapshot>&").append(customClassData.portfoliosnapshot).append("@10");
        resultStrBuffer.append("&<exposuredetailcomment>&").append(customClassData.exposuredetailcomment).append("@10");

        // Customer Eligibility as per Risk Matrix
        resultStrBuffer.append("&<polltv>&").append(customClassData.polltv).append("@10");
        resultStrBuffer.append("&<proltv>&").append(customClassData.proltv).append("@10");
        resultStrBuffer.append("&<polten>&").append(customClassData.polten).append("@10");
        resultStrBuffer.append("&<protenure>&").append(customClassData.protenure).append("@10");
        resultStrBuffer.append("&<variationInLtv>&").append(customClassData.variationInLtv).append("@10");
        resultStrBuffer.append("&<variationInTenure>&").append(customClassData.variationInTenure).append("@10");

        // Query 15 FFR
        resultStrBuffer.append("&<totalfleet>&").append(customClassData.totalfleet).append("@10");
        resultStrBuffer.append("&<totalfleetfinance>&").append(customClassData.totalfleetfinance).append("@10");
        resultStrBuffer.append("&<freefleet>&").append(customClassData.freefleet).append("@10");
        resultStrBuffer.append("&<ffr>&").append(customClassData.ffr).append("@10");
        resultStrBuffer.append("&<ffrcomments>&").append(customClassData.ffrcomments).append("@10");

        // Query 16, 17, 18 and 19 -- Credit Comments
        resultStrBuffer.append("&<overall_comment>&").append(customClassData.overall_comment).append("@10");
        resultStrBuffer.append("&<strenghts>&").append(customClassData.strenghts).append("@10");
        resultStrBuffer.append("&<concerns>&").append(customClassData.concerns).append("@10");
        resultStrBuffer.append("&<finalrecommendation>&").append(customClassData.finalrecommendation).append("@10");

        // Query 20 -- asset category
        resultStrBuffer.append("&<assetCategory>&").append(customClassData.assetCategory).append("@10");

        WFCallBroker.generateLog("GenResp", "\n\nresultStrBuffer.toString: " + resultStrBuffer.toString()+"\n\n");
        System.out.println( "resultStrBuffer.toString: " + resultStrBuffer.toString());
        return resultStrBuffer.toString();
    }

    public List getGenerateResponseCustomTableList(WorkdeskModel workdeskmodel)
    {
        //queryFromDb(workdeskmodel);
        String s = workdeskmodel.getWorkitem().getRouteName();
        String s1 = workdeskmodel.getWorkitem().getActivityName();
        String transactionId = workdeskmodel.getWorkitem().getProcessInstanceId();
        WFCallBroker.generateLog("GenResp", "transactionId2: " + transactionId);
        System.out.println( "transactionId2: " + transactionId);
        CustomClassData customClassData = new CustomClassData(transactionId);
        customClassData.setTabularData();


        ArrayList<TemplateTable> arraylist = new ArrayList<TemplateTable>();
        /*TemplateTable templatetable = new TemplateTable("CMPLX_CAM_COMMENT");
        try
        {
            WiAttribHashMap wiattribhashmap = workdeskmodel.getAttributeMap();
            WorkdeskAttribute workdeskattribute = (WorkdeskAttribute)wiattribhashmap.get("qCAM_CMERetail");
            WiAttribHashMap wiattribhashmap1 = (WiAttribHashMap)workdeskattribute.getAttribValue();
            WorkdeskAttribute workdeskattribute1 = (WorkdeskAttribute)wiattribhashmap1.get("QCAM_CMERETAIL-COMMENT");
            ArrayList arraylist1 = (ArrayList)workdeskattribute1.getAttribValue();
            for(int j = 1; j < arraylist1.size(); j++)
            {
                LinkedHashMap linkedhashmap = (LinkedHashMap)arraylist1.get(j);
                HashMap hashmap = new HashMap();
                hashmap.put("CMPLX_CAM_COMMENT.naME", new TemplateColumn("naME", 10, ((WorkdeskAttribute)linkedhashmap.get("QCAM_CMERETAIL-COMMENT-NAME")).getValue()));
                hashmap.put("CMPLX_CAM_COMMENT.roLE", new TemplateColumn("roLE", 10, ((WorkdeskAttribute)linkedhashmap.get("QCAM_CMERETAIL-COMMENT-ROLE")).getValue()));
                hashmap.put("CMPLX_CAM_COMMENT.grADE", new TemplateColumn("grADE", 10, ((WorkdeskAttribute)linkedhashmap.get("QCAM_CMERETAIL-COMMENT-GRADE")).getValue()));
                hashmap.put("CMPLX_CAM_COMMENT.coMMENTDATE", new TemplateColumn("coMMENTDATE", 10, ((WorkdeskAttribute)linkedhashmap.get("QCAM_CMERETAIL-COMMENT-COMMENTDATE")).getValue()));
                hashmap.put("CMPLX_CAM_COMMENT.reMARKS", new TemplateColumn("reMARKS", 10, ((WorkdeskAttribute)linkedhashmap.get("QCAM_CMERETAIL-COMMENT-REMARKS")).getValue()));
                hashmap.put("CMPLX_CAM_COMMENT.stATUS", new TemplateColumn("stATUS", 10, ((WorkdeskAttribute)linkedhashmap.get("QCAM_CMERETAIL-COMMENT-STATUS")).getValue()));
                hashmap.put("CMPLX_CAM_COMMENT.userid", new TemplateColumn("userid", 10, ((WorkdeskAttribute)linkedhashmap.get("QCAM_CMERETAIL-COMMENT-USERID")).getValue()));
                templatetable.getTableData().add(hashmap);
            }

            arraylist.add(templatetable);
        }
        catch(Exception exception)
        {
            WFCallBroker.generateLog("GenResp", (new StringBuilder()).append("\r\n\r\n Exception ->").append(exception.toString()).toString());
            StackTraceElement astacktraceelement[] = exception.getStackTrace();
            for(int i = 0; i < astacktraceelement.length; i++)
                WFCallBroker.generateLog("GenResp", (new StringBuilder()).append("\r\n ->").append(astacktraceelement[i].toString()).toString());

        }*/

        // tradeReferenceList
        TemplateTable tradeReferenceListTemplate = new TemplateTable("tradeReferenceList");
        try
        {
            for(int j = 0; j < customClassData.tradeReferenceList.size(); j++)
            {
                HashMap<String, TemplateColumn> hashmap = new HashMap<String, TemplateColumn>();
                hashmap.put("tradeReferenceList.personname", new TemplateColumn("personname", 10, customClassData.tradeReferenceList.get(j).get(0)));
                hashmap.put("tradeReferenceList.contactno", new TemplateColumn("contactno", 10, customClassData.tradeReferenceList.get(j).get(1)));
                hashmap.put("tradeReferenceList.detailreference", new TemplateColumn("detailreference", 10, customClassData.tradeReferenceList.get(j).get(2)));
                hashmap.put("tradeReferenceList.relationship", new TemplateColumn("relationship", 10, customClassData.tradeReferenceList.get(j).get(3)));
                hashmap.put("tradeReferenceList.referencecheck", new TemplateColumn("referencecheck", 10, customClassData.tradeReferenceList.get(j).get(4)));
                hashmap.put("tradeReferenceList.remarks", new TemplateColumn("remarks", 10, customClassData.tradeReferenceList.get(j).get(5)));
                tradeReferenceListTemplate.getTableData().add(hashmap);
            }

            arraylist.add(tradeReferenceListTemplate);
        }
        catch(Exception exception)
        {
            WFCallBroker.generateLog("GenResp", (new StringBuilder()).append("\r\n\r\n Exception ->").append(exception.toString()).toString());
            StackTraceElement astacktraceelement[] = exception.getStackTrace();
            for(int i = 0; i < astacktraceelement.length; i++)
                WFCallBroker.generateLog("GenResp", (new StringBuilder()).append("\r\n ->").append(astacktraceelement[i].toString()).toString());

        }

        // facilityRequiredList
        TemplateTable facilityRequiredListTemplate = new TemplateTable("facilityRequiredList");
        try
        {
            for(int j = 0; j < customClassData.facilityRequiredList.size(); j++)
            {
                HashMap<String, TemplateColumn> hashmap = new HashMap<String, TemplateColumn>();
                hashmap.put("facilityRequiredList.assetname", new TemplateColumn("assetname", 10, customClassData.facilityRequiredList.get(j).get(0)));
                hashmap.put("facilityRequiredList.regassetnumber", new TemplateColumn("regassetnumber", 10, customClassData.facilityRequiredList.get(j).get(1)));
                hashmap.put("facilityRequiredList.model", new TemplateColumn("model", 10, customClassData.facilityRequiredList.get(j).get(2)));
                hashmap.put("facilityRequiredList.quantity", new TemplateColumn("quantity", 10, customClassData.facilityRequiredList.get(j).get(3)));
                hashmap.put("facilityRequiredList.assetcost", new TemplateColumn("assetcost", 10, customClassData.facilityRequiredList.get(j).get(4)));
                hashmap.put("facilityRequiredList.quippovalue", new TemplateColumn("quippovalue", 10, customClassData.facilityRequiredList.get(j).get(5)));
                hashmap.put("facilityRequiredList.gridvalue", new TemplateColumn("gridvalue", 10, customClassData.facilityRequiredList.get(j).get(6)));
                hashmap.put("facilityRequiredList.idvvalue", new TemplateColumn("idvvalue", 10, customClassData.facilityRequiredList.get(j).get(7)));
                hashmap.put("facilityRequiredList.ltv", new TemplateColumn("ltv", 10, customClassData.facilityRequiredList.get(j).get(8)));
                hashmap.put("facilityRequiredList.financeamt", new TemplateColumn("financeamt", 10, customClassData.facilityRequiredList.get(j).get(9)));
                hashmap.put("facilityRequiredList.irrpersent", new TemplateColumn("irrpersent", 10, customClassData.facilityRequiredList.get(j).get(10)));
                hashmap.put("facilityRequiredList.tenure", new TemplateColumn("tenure", 10, customClassData.facilityRequiredList.get(j).get(11)));
                hashmap.put("facilityRequiredList.moratorium", new TemplateColumn("moratorium", 10, customClassData.facilityRequiredList.get(j).get(12)));
                hashmap.put("facilityRequiredList.asset_segment", new TemplateColumn("asset_segment", 10, customClassData.facilityRequiredList.get(j).get(13)));
                facilityRequiredListTemplate.getTableData().add(hashmap);
            }
            arraylist.add(facilityRequiredListTemplate);
        }
        catch(Exception exception)
        {
            WFCallBroker.generateLog("GenResp", (new StringBuilder()).append("\r\n\r\n Exception ->").append(exception.toString()).toString());
            StackTraceElement astacktraceelement[] = exception.getStackTrace();
            for(int i = 0; i < astacktraceelement.length; i++)
                WFCallBroker.generateLog("GenResp", (new StringBuilder()).append("\r\n ->").append(astacktraceelement[i].toString()).toString());

        }

        // exposureDetailsList
        TemplateTable exposureDetailsListTemplate = new TemplateTable("exposureDetailsList");
        try
        {
            for(int j = 0; j < customClassData.exposureDetailsList.size(); j++)
            {
                HashMap<String, TemplateColumn> hashmap = new HashMap<String, TemplateColumn>();
                hashmap.put("exposureDetailsList.particulars", new TemplateColumn("particulars", 10, customClassData.exposureDetailsList.get(j).get(0)));
                hashmap.put("exposureDetailsList.client", new TemplateColumn("client", 10, customClassData.exposureDetailsList.get(j).get(1)));
                hashmap.put("exposureDetailsList.guarantor", new TemplateColumn("guarantor", 10, customClassData.exposureDetailsList.get(j).get(2)));
                hashmap.put("exposureDetailsList.groupexposure", new TemplateColumn("groupexposure", 10, customClassData.exposureDetailsList.get(j).get(3)));
                hashmap.put("exposureDetailsList.exptotal", new TemplateColumn("exptotal", 10, customClassData.exposureDetailsList.get(j).get(4)));
                exposureDetailsListTemplate.getTableData().add(hashmap);
            }
            arraylist.add(exposureDetailsListTemplate);
        }
        catch(Exception exception)
        {
            WFCallBroker.generateLog("GenResp", (new StringBuilder()).append("\r\n\r\n Exception ->").append(exception.toString()).toString());
            StackTraceElement astacktraceelement[] = exception.getStackTrace();
            for(int i = 0; i < astacktraceelement.length; i++)
                WFCallBroker.generateLog("GenResp", (new StringBuilder()).append("\r\n ->").append(astacktraceelement[i].toString()).toString());

        }

        // managementOwnershipList
        TemplateTable managementOwnershipListTemplate = new TemplateTable("managementOwnershipList");
        try
        {
            for(int j = 0; j < customClassData.managementOwnershipList.size(); j++)
            {
                HashMap<String, TemplateColumn> hashmap = new HashMap<String, TemplateColumn>();
                hashmap.put("managementOwnershipList.partyname", new TemplateColumn("partyname", 10, customClassData.managementOwnershipList.get(j).get(0)));
                hashmap.put("managementOwnershipList.holding", new TemplateColumn("holding", 10, customClassData.managementOwnershipList.get(j).get(1)));
                hashmap.put("managementOwnershipList.relationship", new TemplateColumn("relationship", 10, customClassData.managementOwnershipList.get(j).get(2)));
                hashmap.put("managementOwnershipList.dob_doi", new TemplateColumn("dob_doi", 10, customClassData.managementOwnershipList.get(j).get(3)));
                hashmap.put("managementOwnershipList.cibilscore", new TemplateColumn("cibilscore", 10, customClassData.managementOwnershipList.get(j).get(4)));
                managementOwnershipListTemplate.getTableData().add(hashmap);
            }
            arraylist.add(managementOwnershipListTemplate);
        }
        catch(Exception exception)
        {
            WFCallBroker.generateLog("GenResp", (new StringBuilder()).append("\r\n\r\n Exception ->").append(exception.toString()).toString());
            StackTraceElement astacktraceelement[] = exception.getStackTrace();
            for(int i = 0; i < astacktraceelement.length; i++)
                WFCallBroker.generateLog("GenResp", (new StringBuilder()).append("\r\n ->").append(astacktraceelement[i].toString()).toString());

        }

        // constructionEquipmentList
        TemplateTable constructionEquipmentListTemplate = new TemplateTable("constructionEquipmentList");
        try
        {
            for(int j = 0; j < customClassData.constructionEquipmentList.size(); j++)
            {
                HashMap<String, TemplateColumn> hashmap = new HashMap<String, TemplateColumn>();
                hashmap.put("constructionEquipmentList.assetowner", new TemplateColumn("assetowner", 10, customClassData.constructionEquipmentList.get(j).get(0)));
                hashmap.put("constructionEquipmentList.equipmenttype", new TemplateColumn("equipmenttype", 10, customClassData.constructionEquipmentList.get(j).get(1)));
                hashmap.put("constructionEquipmentList.modelno", new TemplateColumn("modelno", 10, customClassData.constructionEquipmentList.get(j).get(2)));
                hashmap.put("constructionEquipmentList.yearmfg", new TemplateColumn("yearmfg", 10, customClassData.constructionEquipmentList.get(j).get(3)));
                hashmap.put("constructionEquipmentList.reginvoiceno", new TemplateColumn("reginvoiceno", 10, customClassData.constructionEquipmentList.get(j).get(4)));
                hashmap.put("constructionEquipmentList.frrefinance", new TemplateColumn("frrefinance", 10, customClassData.constructionEquipmentList.get(j).get(5)));
                hashmap.put("constructionEquipmentList.nameoffinancier", new TemplateColumn("nameoffinancier", 10, customClassData.constructionEquipmentList.get(j).get(6)));
                hashmap.put("constructionEquipmentList.fallenortenure", new TemplateColumn("fallenortenure", 10, customClassData.constructionEquipmentList.get(j).get(7)));
                hashmap.put("constructionEquipmentList.peakdelayoravgdelay", new TemplateColumn("peakdelayoravgdelay", 10, customClassData.constructionEquipmentList.get(j).get(8)));
                constructionEquipmentListTemplate.getTableData().add(hashmap);
            }
            arraylist.add(constructionEquipmentListTemplate);
        }
        catch(Exception exception)
        {
            WFCallBroker.generateLog("GenResp", (new StringBuilder()).append("\r\n\r\n Exception ->").append(exception.toString()).toString());
            StackTraceElement astacktraceelement[] = exception.getStackTrace();
            for(int i = 0; i < astacktraceelement.length; i++)
                WFCallBroker.generateLog("GenResp", (new StringBuilder()).append("\r\n ->").append(astacktraceelement[i].toString()).toString());

        }

        // existingExposureWithSreiList
        TemplateTable existingExposureWithSreiListTemplate = new TemplateTable("existingExposureWithSreiList");
        try
        {
            for(int j = 0; j < customClassData.existingExposureWithSreiList.size(); j++)
            {
                HashMap<String, TemplateColumn> hashmap = new HashMap<String, TemplateColumn>();
                hashmap.put("existingExposureWithSreiList.assetowner", new TemplateColumn("assetowner", 10, customClassData.existingExposureWithSreiList.get(j).get(0)));
                hashmap.put("existingExposureWithSreiList.assetfunded", new TemplateColumn("assetfunded", 10, customClassData.existingExposureWithSreiList.get(j).get(1)));
                hashmap.put("existingExposureWithSreiList.contractnumber", new TemplateColumn("contractnumber", 10, customClassData.existingExposureWithSreiList.get(j).get(2)));
                hashmap.put("existingExposureWithSreiList.year", new TemplateColumn("year", 10, customClassData.existingExposureWithSreiList.get(j).get(3)));
                hashmap.put("existingExposureWithSreiList.assetcost", new TemplateColumn("assetcost", 10, customClassData.existingExposureWithSreiList.get(j).get(4)));
                hashmap.put("existingExposureWithSreiList.financeamount", new TemplateColumn("financeamount", 10, customClassData.existingExposureWithSreiList.get(j).get(5)));
                hashmap.put("existingExposureWithSreiList.pos", new TemplateColumn("pos", 10, customClassData.existingExposureWithSreiList.get(j).get(6)));
                hashmap.put("existingExposureWithSreiList.totaloutstanding", new TemplateColumn("totaloutstanding", 10, customClassData.existingExposureWithSreiList.get(j).get(7)));
                hashmap.put("existingExposureWithSreiList.tenor", new TemplateColumn("tenor", 10, customClassData.existingExposureWithSreiList.get(j).get(8)));
                hashmap.put("existingExposureWithSreiList.peakaveragedelay", new TemplateColumn("peakaveragedelay", 10, customClassData.existingExposureWithSreiList.get(j).get(9)));
                hashmap.put("existingExposureWithSreiList.sreigridvalue", new TemplateColumn("sreigridvalue", 10, customClassData.existingExposureWithSreiList.get(j).get(10)));
                hashmap.put("existingExposureWithSreiList.dpd", new TemplateColumn("dpd", 10, customClassData.existingExposureWithSreiList.get(j).get(11)));
                hashmap.put("existingExposureWithSreiList.alg", new TemplateColumn("alg", 10, customClassData.existingExposureWithSreiList.get(j).get(12)));
                existingExposureWithSreiListTemplate.getTableData().add(hashmap);
            }
            arraylist.add(existingExposureWithSreiListTemplate);
        }
        catch(Exception exception)
        {
            WFCallBroker.generateLog("GenResp", (new StringBuilder()).append("\r\n\r\n Exception ->").append(exception.toString()).toString());
            StackTraceElement astacktraceelement[] = exception.getStackTrace();
            for(int i = 0; i < astacktraceelement.length; i++)
                WFCallBroker.generateLog("GenResp", (new StringBuilder()).append("\r\n ->").append(astacktraceelement[i].toString()).toString());

        }

        // existingExposureWithSreiList
        TemplateTable detailsOfContractInHandListTemplate = new TemplateTable("detailsOfContractInHandList");
        try
        {
            for(int j = 0; j < customClassData.detailsOfContractInHandList.size(); j++)
            {
                HashMap<String, TemplateColumn> hashmap = new HashMap<String, TemplateColumn>();
                hashmap.put("detailsOfContractInHandList.srl", new TemplateColumn("srl", 10, customClassData.detailsOfContractInHandList.get(j).get(0)));
                hashmap.put("detailsOfContractInHandList.principalname", new TemplateColumn("principalname", 10, customClassData.detailsOfContractInHandList.get(j).get(1)));
                hashmap.put("detailsOfContractInHandList.natureofwork", new TemplateColumn("natureofwork", 10, customClassData.detailsOfContractInHandList.get(j).get(2)));
                hashmap.put("detailsOfContractInHandList.originalcontractvalue", new TemplateColumn("originalcontractvalue", 10, customClassData.detailsOfContractInHandList.get(j).get(3)));
                hashmap.put("detailsOfContractInHandList.residual", new TemplateColumn("residual", 10, customClassData.detailsOfContractInHandList.get(j).get(4)));
                hashmap.put("detailsOfContractInHandList.mobilizationadv", new TemplateColumn("mobilizationadv", 10, customClassData.detailsOfContractInHandList.get(j).get(5)));
                hashmap.put("detailsOfContractInHandList.startdate", new TemplateColumn("startdate", 10, customClassData.detailsOfContractInHandList.get(j).get(6)));
                hashmap.put("detailsOfContractInHandList.expectedenddate", new TemplateColumn("expectedenddate", 10, customClassData.detailsOfContractInHandList.get(j).get(7)));
                hashmap.put("detailsOfContractInHandList.qualityofprincipal", new TemplateColumn("qualityofprincipal", 10, customClassData.detailsOfContractInHandList.get(j).get(8)));
                hashmap.put("detailsOfContractInHandList.orderbook", new TemplateColumn("orderbook", 10, customClassData.detailsOfContractInHandList.get(j).get(9)));
                detailsOfContractInHandListTemplate.getTableData().add(hashmap);
            }
            arraylist.add(detailsOfContractInHandListTemplate);
        }
        catch(Exception exception)
        {
            WFCallBroker.generateLog("GenResp", (new StringBuilder()).append("\r\n\r\n Exception ->").append(exception.toString()).toString());
            StackTraceElement astacktraceelement[] = exception.getStackTrace();
            for(int i = 0; i < astacktraceelement.length; i++)
                WFCallBroker.generateLog("GenResp", (new StringBuilder()).append("\r\n ->").append(astacktraceelement[i].toString()).toString());

        }

        // financialHighlightList
        TemplateTable financialHighlightListTemplate = new TemplateTable("financialHighlightList");
        try
        {
            for(int j = 0; j < customClassData.financialHighlightList.size(); j++)
            {
                HashMap<String, TemplateColumn> hashmap = new HashMap<String, TemplateColumn>();
                hashmap.put("financialHighlightList.col0", new TemplateColumn("col0", 10, customClassData.financialHighlightList.get(j).get(0)));
                hashmap.put("financialHighlightList.col1", new TemplateColumn("col1", 10, customClassData.financialHighlightList.get(j).get(1)));
                hashmap.put("financialHighlightList.col2", new TemplateColumn("col2", 10, customClassData.financialHighlightList.get(j).get(2)));
                hashmap.put("financialHighlightList.col3", new TemplateColumn("col3", 10, customClassData.financialHighlightList.get(j).get(3)));
                hashmap.put("financialHighlightList.col4", new TemplateColumn("col4", 10, customClassData.financialHighlightList.get(j).get(4)));
                financialHighlightListTemplate.getTableData().add(hashmap);
            }
            arraylist.add(financialHighlightListTemplate);
        }
        catch(Exception exception)
        {
            WFCallBroker.generateLog("GenResp", (new StringBuilder()).append("\r\n\r\n Exception ->").append(exception.toString()).toString());
            StackTraceElement astacktraceelement[] = exception.getStackTrace();
            for(int i = 0; i < astacktraceelement.length; i++)
                WFCallBroker.generateLog("GenResp", (new StringBuilder()).append("\r\n ->").append(astacktraceelement[i].toString()).toString());

        }

        // externalLiabilityList
        TemplateTable externalLiabilityListTemplate = new TemplateTable("externalLiabilityList");
        try
        {
            for(int j = 0; j < customClassData.externalLiabilityList.size(); j++)
            {
                HashMap<String, TemplateColumn> hashmap = new HashMap<String, TemplateColumn>();
                hashmap.put("externalLiabilityList.rownum", new TemplateColumn("rownum", 10, customClassData.externalLiabilityList.get(j).get(0)));
                hashmap.put("externalLiabilityList.description", new TemplateColumn("description", 10, customClassData.externalLiabilityList.get(j).get(1)));
                hashmap.put("externalLiabilityList.nameofbank", new TemplateColumn("nameofbank", 10, customClassData.externalLiabilityList.get(j).get(2)));
                hashmap.put("externalLiabilityList.amount", new TemplateColumn("amount", 10, customClassData.externalLiabilityList.get(j).get(3)));
                hashmap.put("externalLiabilityList.overdue", new TemplateColumn("overdue", 10, customClassData.externalLiabilityList.get(j).get(4)));
                hashmap.put("externalLiabilityList.installmentamount", new TemplateColumn("installmentamount", 10, customClassData.externalLiabilityList.get(j).get(5)));
                externalLiabilityListTemplate.getTableData().add(hashmap);
            }
            arraylist.add(externalLiabilityListTemplate);
        }
        catch(Exception exception)
        {
            WFCallBroker.generateLog("GenResp", (new StringBuilder()).append("\r\n\r\n Exception ->").append(exception.toString()).toString());
            StackTraceElement astacktraceelement[] = exception.getStackTrace();
            for(int i = 0; i < astacktraceelement.length; i++)
                WFCallBroker.generateLog("GenResp", (new StringBuilder()).append("\r\n ->").append(astacktraceelement[i].toString()).toString());
        }

        // bankingDetailsList
        TemplateTable bankingDetailsListTemplate = new TemplateTable("bankingDetailsList");
        try
        {
            for(int j = 0; j < customClassData.bankingDetailsList.size(); j++)
            {
                HashMap<String, TemplateColumn> hashmap = new HashMap<String, TemplateColumn>();
                hashmap.put("bankingDetailsList.monthtxt", new TemplateColumn("monthtxt", 10, customClassData.bankingDetailsList.get(j).get(0)));
                hashmap.put("bankingDetailsList.balanceupto15", new TemplateColumn("balanceupto15", 10, customClassData.bankingDetailsList.get(j).get(1)));
                hashmap.put("bankingDetailsList.balanceupto31", new TemplateColumn("balanceupto31", 10, customClassData.bankingDetailsList.get(j).get(2)));
                hashmap.put("bankingDetailsList.credits", new TemplateColumn("credits", 10, customClassData.bankingDetailsList.get(j).get(3)));
                bankingDetailsListTemplate.getTableData().add(hashmap);
            }
            arraylist.add(bankingDetailsListTemplate);
        }
        catch(Exception exception)
        {
            WFCallBroker.generateLog("GenResp", (new StringBuilder()).append("\r\n\r\n Exception ->").append(exception.toString()).toString());
            StackTraceElement astacktraceelement[] = exception.getStackTrace();
            for(int i = 0; i < astacktraceelement.length; i++)
                WFCallBroker.generateLog("GenResp", (new StringBuilder()).append("\r\n ->").append(astacktraceelement[i].toString()).toString());
        }

        // clientHistoryList
        TemplateTable clientHistoryListTemplate = new TemplateTable("clientHistoryList");
        try
        {
            for(int j = 0; j < customClassData.clientHistoryList.size(); j++)
            {
                HashMap<String, TemplateColumn> hashmap = new HashMap<String, TemplateColumn>();
                hashmap.put("clientHistoryList.camdate", new TemplateColumn("camdate", 10, customClassData.clientHistoryList.get(j).get(0)));
                hashmap.put("clientHistoryList.approvedexposure", new TemplateColumn("approvedexposure", 10, customClassData.clientHistoryList.get(j).get(1)));
                hashmap.put("clientHistoryList.existingexposure", new TemplateColumn("existingexposure", 10, customClassData.clientHistoryList.get(j).get(2)));
                hashmap.put("clientHistoryList.totalexposure", new TemplateColumn("totalexposure", 10, customClassData.clientHistoryList.get(j).get(3)));
                hashmap.put("clientHistoryList.approval_level", new TemplateColumn("approval_level", 10, customClassData.clientHistoryList.get(j).get(4)));
                clientHistoryListTemplate.getTableData().add(hashmap);
            }
            arraylist.add(clientHistoryListTemplate);
        }
        catch(Exception exception)
        {
            WFCallBroker.generateLog("GenResp", (new StringBuilder()).append("\r\n\r\n Exception ->").append(exception.toString()).toString());
            StackTraceElement astacktraceelement[] = exception.getStackTrace();
            for(int i = 0; i < astacktraceelement.length; i++)
                WFCallBroker.generateLog("GenResp", (new StringBuilder()).append("\r\n ->").append(astacktraceelement[i].toString()).toString());
        }
        return arraylist;
    }

}

class CustomClassData {

    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
    String transactionId = "";

    // Db Connection Values
    String dbIp;
    String dbPort;
    String dbServiceName;
    String connectionString;
    String cabinetName;
    String cabinetPassword;
    Connection con = null;

    String leadpwid = ""; // query1

    String cam_no = ""; // query1
    String currentdate = ""; // new date
    String camtype = ""; // query1
    String classification = ""; // query1
    String business_model_new = ""; // query1
    String assetfinancecategory = ""; // query3
    String sector = ""; // query4
    String product = ""; // query2
    String subsector = ""; // query4
    String subsectorcode = ""; // query5
    String customercategory = ""; // query4
    String region = ""; // query1
    String geographiccategory = ""; // query1
    String branch = ""; // query1
    String negativearea = ""; // query4
    String distance_frm_srei_office = ""; // query1
    String cautionprofile = ""; // query4
    String rmname = ""; // query1
    String collectionofficer = ""; // query6
    String classofcontractor = ""; // query4

    // --------------- Applicant Variables ---------------------
     String partynameApplicant = "", relationshipApplicant = "", addressApplicant = "", mobilenumApplicant = "",
            emailaddApplicant = "", websiteApplicant = "", constitutionApplicant = "", dobApplicant = "", bussexpApplicant = "",
            sreiexistingcustomerApplicant = "", cibilscoreApplicant = "", experianscoreApplicant = "", equifaxscoreApplicant = "",
            crifscoreApplicant = "", cibilscorecommentsApplicant = "",resifinumberApplicant = "", resificommentsApplicant = "",
            officefinumberApplicant = "", officeficommentsApplicant = "", residencestabilityApplicant = "",
            residencestatusApplicant = "", tvrdecisionApplicant = "", tvrcommentsApplicant = "", pslcategoryApplicant = "",
            riskcategoryofcustomerApplicant = "", riskcategorycustuserApplicant = "", fleetsizeApplicant = "",
            ratingagencyApplicant = "", riskgradeApplicant = "", Creditenhancement1Applicant = "",
            agreewithratingsApplicant = "", Creditenhancement2Applicant = "", assetexperienceApplicant = "",
            lengthofassociation_pdpApplicant = "";
    // --------------- Co-Applicant Variables ------------------
    String partynameCoApplicant = "", relationshipCoApplicant = "", addressCoApplicant = "", mobilenumCoApplicant = "",
            emailaddCoApplicant = "", websiteCoApplicant = "", constitutionCoApplicant = "", dobCoApplicant = "",
            bussexpCoApplicant = "", sreiexistingcustomerCoApplicant = "", cibilscoreCoApplicant = "",
            experianscoreCoApplicant = "", equifaxscoreCoApplicant = "", crifscoreCoApplicant = "", cibilscorecommentsCoApplicant = "",
            resifinumberCoApplicant = "", resificommentsCoApplicant = "", officefinumberCoApplicant = "",
            officeficommentsCoApplicant = "", residencestabilityCoApplicant = "",
            residencestatusCoApplicant = "", tvrdecisionCoApplicant = "", tvrcommentsCoApplicant = "",
            pslcategoryCoApplicant = "", riskcategoryofcustomerCoApplicant = "", riskcategorycustuserCoApplicant = "",
            fleetsizeCoApplicant = "", ratingagencyCoApplicant = "", riskgradeCoApplicant = "", Creditenhancement1CoApplicant = "",
            agreewithratingsCoApplicant = "", Creditenhancement2CoApplicant = "", assetexperienceCoApplicant = "", lengthofassociation_pdpCoApplicant = "";
    // --------------- Guarantor Variables ---------------------
    String partynameGuarantor = "", relationshipGuarantor = "", addressGuarantor = "", mobilenumGuarantor = "",
            emailaddGuarantor = "", websiteGuarantor = "", constitutionGuarantor = "", dobGuarantor = "", bussexpGuarantor = "",
            sreiexistingcustomerGuarantor = "", cibilscoreGuarantor = "", experianscoreGuarantor = "", equifaxscoreGuarantor = "",
            crifscoreGuarantor = "", cibilscorecommentsGuarantor = "", resifinumberGuarantor = "",
            resificommentsGuarantor = "", officefinumberGuarantor = "", officeficommentsGuarantor = "", residencestabilityGuarantor = "",
            residencestatusGuarantor = "", tvrdecisionGuarantor = "", tvrcommentsGuarantor = "", pslcategoryGuarantor = "", riskcategoryofcustomerGuarantor = "",
            riskcategorycustuserGuarantor = "", fleetsizeGuarantor = "", ratingagencyGuarantor = "", riskgradeGuarantor = "", Creditenhancement1Guarantor = "",
            agreewithratingsGuarantor = "", Creditenhancement2Guarantor = "", assetexperienceGuarantor = "", lengthofassociation_pdpGuarantor = "",
            relationshiptypeGuarantor = "";

    // --------------- Query10 Variables ---------------------
    String natureofwork = "", businessbackground = "", gurantorbackground = "", majorprincipal = "", proposedassets = "",
            existingassetscomment = "", coapplicantprofile = "", group_profile = "", assethistory = "", quippovaluationreport = "",
            existingexposurecomment = "", existingexposureconduct = "", viabilitycalculation = "", foirresult = "",
            foir = "", inhandcontractcomment = "", commentfinancialhighlights = "", particulars = "", dscr = "", acr = "",
            externalliabilitycomment = "", periodfrom = "", periodto = "", totalbilling = "", totalpaymentreceived = "",
            currentyearworking = "", portfoliosnapshot = "", exposuredetailcomment = "";

    // --------- Customer Eligibility as per Risk Matrix ------
    String assetCategory = "";
    String polltv = "", proltv = "", polten = "", protenure = "";
    private double polltvDouble = 0.0, proltvDouble = 0.0, poltenDouble = 0.0, protenureDouble = 0.0;
    String variationInLtv = "", variationInTenure;

    // --------------- Query15 Variables ---------------------
    String totalfleet = "", totalfleetfinance = "", freefleet = "", ffr = "", ffrcomments = "";

    // --------------- Credit Comments ------------------------
    String overall_comment = "", strenghts = "", concerns = "", finalrecommendation = "";

    // Tabular Data Variables
    ArrayList<ArrayList<String>> tradeReferenceList = new ArrayList<ArrayList<String>>();
    ArrayList<ArrayList<String>> facilityRequiredList = new ArrayList<ArrayList<String>>();
    ArrayList<ArrayList<String>> exposureDetailsList = new ArrayList<ArrayList<String>>();
    ArrayList<ArrayList<String>> managementOwnershipList = new ArrayList<ArrayList<String>>();
    ArrayList<ArrayList<String>> constructionEquipmentList = new ArrayList<ArrayList<String>>();
    ArrayList<ArrayList<String>> ffrResultList = new ArrayList<ArrayList<String>>();
    ArrayList<ArrayList<String>> existingExposureWithSreiList = new ArrayList<ArrayList<String>>();
    ArrayList<ArrayList<String>> detailsOfContractInHandList = new ArrayList<ArrayList<String>>();
    ArrayList<ArrayList<String>> externalLiabilityList = new ArrayList<ArrayList<String>>();
    ArrayList<ArrayList<String>> bankingDetailsList = new ArrayList<ArrayList<String>>();
    ArrayList<ArrayList<String>> financialHighlightList = new ArrayList<ArrayList<String>>();
    ArrayList<ArrayList<String>> clientHistoryList = new ArrayList<ArrayList<String>>();

    CustomClassData(){}

    CustomClassData(String transactionId){
        this.transactionId = transactionId;
        setDBParameters();
    }

    void setDBParameters(){
        WFCallBroker.generateLog("GenResp", "\nInside setDBParameters\n");
        String filePath = System.getProperty("user.dir") + File.separator + "CamReport.properties";
        WFCallBroker.generateLog("GenResp", "\nfilePath: " + filePath + "\n");

        Properties prop = new Properties();
        try{
            prop.load(new FileInputStream(System.getProperty("user.dir") + File.separator + "CamReport.properties"));
        }catch (IOException ioException){
            WFCallBroker.generateLog("GenResp", "\nioException: " + ioException + "\n");
        }


        // dbIp
        if (!(prop.containsKey("dbIp"))) {
            this.dbIp = "";
        } else {
            this.dbIp =  prop.getProperty("dbIp");
        }

        // dbPort
        if (!(prop.containsKey("dbPort"))) {
            this.dbPort = "";
        } else {
            this.dbPort =  prop.getProperty("dbPort");
        }

        // dbServiceName
        if (!(prop.containsKey("dbServiceName"))) {
            this.dbServiceName = "";
        } else {
            this.dbServiceName =  prop.getProperty("dbServiceName");
        }

        // cabinetName
        if (!(prop.containsKey("cabinetName"))) {
            this.cabinetName = "";
        } else {
            this.cabinetName =  prop.getProperty("cabinetName");
        }

        // cabinetPassword
        if (!(prop.containsKey("cabinetPassword"))) {
            this.cabinetPassword = "";
        } else {
            this.cabinetPassword =  prop.getProperty("cabinetPassword");
        }

        connectionString = "jdbc:oracle:thin:@" + dbIp + ":" + dbPort + ":" + dbServiceName;
        WFCallBroker.generateLog("GenResp", "\nconnectionString: " + connectionString + "\n");
    }

    void setLinearFields(){
        WFCallBroker.generateLog("GenResp", "Inside setLinearFields");
        System.out.println( "Inside setLinearFields");

        Date newDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        currentdate = sdf.format(newDate);

        /////////////////////////////////// Query 1 /////////////////////////////////////////////////
        try{
            con = createConnection();
            Statement stmt = con.createStatement();
            ResultSet resultData = null;
            String query1 = "SELECT cam_no,camtype,classification,business_model_new,region,geographiccategory,branch," +
                    "rmname, lead_pwid  " +
                    "FROM ext_los_cam " +
                    "WHERE transactionid = '" + transactionId + "'";
            WFCallBroker.generateLog("GenResp", "query1: "+query1);
            System.out.println("query1: "+query1);
            resultData = stmt.executeQuery(query1);
            WFCallBroker.generateLog("GenResp", "resultData: "+resultData);
            System.out.println("resultData: "+resultData);
            while (resultData.next()) {
                cam_no = resultData.getString(1) != null ? resultData.getString(1) : "";
                camtype = resultData.getString(2) != null ? resultData.getString(2) : "";
                classification = resultData.getString(3) != null ? resultData.getString(3) : "";
                business_model_new = resultData.getString(4) != null ? resultData.getString(4) : "";
                region = resultData.getString(5) != null ? resultData.getString(5) : "";
                geographiccategory = resultData.getString(6) != null ? resultData.getString(6) : "";
                branch = resultData.getString(7) != null ? resultData.getString(7) : "";
                rmname = resultData.getString(8) != null ? resultData.getString(8) : "";
                leadpwid = resultData.getString(9) != null ? resultData.getString(9) : "";
            }
        }catch (SQLException sqlEx){
            System.out.println("sqlEx: " + sqlEx);
        }catch (Exception e){
            System.out.println("e: " + e);
        }

        /////////////////////////////////// Query 2 /////////////////////////////////////////////////
        try{
            if(con==null){
                con = createConnection();
            }
            Statement stmt = con.createStatement();
            ResultSet resultData = null;
            String query2 = "SELECT product " +
                    "FROM cmplx_cam_quotesattach " +
                    "WHERE transactionno = '" + transactionId + "'";
            WFCallBroker.generateLog("GenResp", "query2: "+query2);
            System.out.println("query2: "+query2);
            resultData = stmt.executeQuery(query2);
            while (resultData.next()) {
                product = resultData.getString(1) != null ? resultData.getString(1) : "";
            }
        }catch (SQLException sqlEx){
            System.out.println("sqlEx: " + sqlEx);
        }catch (Exception e){
            System.out.println("e: " + e);
        }

        /////////////////////////////////// Query 3 /////////////////////////////////////////////////
        try{
            if(con==null){
                con = createConnection();
            }
            Statement stmt = con.createStatement();
            ResultSet resultData = null;
            String query3 = "SELECT detaillov " +
                    "FROM cmplx_cam_miscellaneous " +
                    "WHERE transactionno = '" + transactionId + "' AND fieldname = 'Asset Finance Category'";
            WFCallBroker.generateLog("GenResp", "query3: "+query3);
            System.out.println("query3: "+query3);
            resultData = stmt.executeQuery(query3);
            while (resultData.next()) {
                assetfinancecategory = resultData.getString(1) != null ? resultData.getString(1) : "";
            }
        }catch (SQLException sqlEx){
            System.out.println("sqlEx: " + sqlEx);
        }catch (Exception e){
            System.out.println("e: " + e);
        }

        /////////////////////////////////// Query 4 /////////////////////////////////////////////////
        try{
            if(con==null){
                con = createConnection();
            }
            Statement stmt = con.createStatement();
            ResultSet resultData = null;
            String query4 = "SELECT sector, subsector, customercategory, negativearea, cautionprofile, classofcontractor, distancefromsrei distance_frm_srei_office " +
                    "FROM cmplx_cmeretail " +
                    "WHERE transactionno = '" + transactionId + "'";
            WFCallBroker.generateLog("GenResp", "query3: "+query4);
            System.out.println("query4: "+query4);
            resultData = stmt.executeQuery(query4);
            while (resultData.next()) {
                sector = resultData.getString(1) != null ? resultData.getString(1) : "";
                subsector = resultData.getString(2) != null ? resultData.getString(2) : "";
                customercategory = resultData.getString(3) != null ? resultData.getString(3) : "";
                negativearea = resultData.getString(4) != null ? resultData.getString(4) : "";
                cautionprofile = resultData.getString(5) != null ? resultData.getString(5) : "";
                classofcontractor = resultData.getString(6) != null ? resultData.getString(6) : "";
                distance_frm_srei_office = resultData.getString(7) != null ? resultData.getString(7) : "";
            }
        }catch (SQLException sqlEx){
            System.out.println("sqlEx: " + sqlEx);
        }catch (Exception e){
            System.out.println("e: " + e);
        }

        /////////////////////////////////// Query 5 /////////////////////////////////////////////////
        try{
            if(con==null){
                con = createConnection();
            }
            Statement stmt = con.createStatement();
            ResultSet resultData = null;
            String query5 = "SELECT subsectorcode " +
                    "FROM custom_sectoriformation " +
                    "WHERE sector = '" + sector + "' AND subsector = '" + subsector + "'";
            WFCallBroker.generateLog("GenResp", "query5: "+query5);
            System.out.println("query5: "+query5);
            resultData = stmt.executeQuery(query5);
            while (resultData.next()) {
                subsectorcode = resultData.getString(1) != null ? resultData.getString(1) : "";
            }
        }catch (SQLException sqlEx){
            System.out.println("sqlEx: " + sqlEx);
        }catch (Exception e){
            System.out.println("e: " + e);
        }

        /////////////////////////////////// Query 6 /////////////////////////////////////////////////
        try{
            if(con==null){
                con = createConnection();
            }
            Statement stmt = con.createStatement();
            ResultSet resultData = null;
            String query6 = "SELECT collectionofficer " +
                    "FROM ext_lms " +
                    "WHERE wid = '" + leadpwid + "'";
            WFCallBroker.generateLog("GenResp", "query6: "+query6);
            System.out.println("query6: "+query6);
            resultData = stmt.executeQuery(query6);
            while (resultData.next()) {
                collectionofficer = resultData.getString(1) != null ? resultData.getString(1) : "";
            }
        }catch (SQLException sqlEx){
            System.out.println("sqlEx: " + sqlEx);
        }catch (Exception e){
            System.out.println("e: " + e);
        }

        // Applicant Query
        /////////////////////////////////// Query 7 /////////////////////////////////////////////////
        try{
            if(con==null){
                con = createConnection();
            }
            Statement stmt = con.createStatement();
            ResultSet resultData = null;
            String query7 = "select b.partyname, 'Self' relationship, d.address||' '||d.city||' '||d.state||' '||d.zipcode address," +
                    "d.mobilenum,d.emailadd,d.website,nvl(a.constitution,'NA') constitution, " +
                    "decode(a.customertype,'Individual',a.dob,a.dateofincorporation) dob," +
                    "(select e.detailtext from  cmplx_cam_miscellaneous e  where e.transactionno=b.transactionid and e.fieldname='Years of experience in Business') bussexp," +
                    "c.sreiexistingcustomer, c.cibilscore, c.experianscore, c.equifaxscore, c.crifscore, " +
                    "c.cibilscorecomments, c.internalfinumber resifinumber,c.fi_final_decision resificomments," +
                    "c.internalfinumber officefinumber,c.fi_final_decision officeficomments," +
                    "c.residencestability,c.residencestatus, c.tvrdecision, c.tvrcomments, c.pslcategory, " +
                    "c.riskcategoryofcustomer,c.riskcategorycustuser,c.fleetsize, c.crratingagency ratingagency, " +
                    "c.sefplclientgrading riskgrade, c.Creditenhancement1, c.agreewithratings,c.Creditenhancement2," +
                    "c.assetexperience, c.lengthofassociation_pdp " +
                    "from party_master a, ext_los_cam b, cmplx_cmeretail c, party_address_master d  " +
                    "where b.partynumber=a.referencepartynumber " +
                    "and a.partynumber=d.partynumber(+) " +
                    "and d.primarystatus(+)='Yes' " +
                    "and c.transactionno=b.transactionid " +
                    "and b.transactionid='" + transactionId + "'";
            WFCallBroker.generateLog("GenResp", "query7: "+query7);
            System.out.println("query7: "+query7);
            resultData = stmt.executeQuery(query7);
            while (resultData.next()) {
                partynameApplicant = resultData.getString(1) != null ? resultData.getString(1) : "";
                relationshipApplicant = resultData.getString(2) != null ? resultData.getString(2) : "";
                addressApplicant = resultData.getString(3) != null ? resultData.getString(3) : "";
                mobilenumApplicant = resultData.getString(4) != null ? resultData.getString(4) : "";
                emailaddApplicant = resultData.getString(5) != null ? resultData.getString(5) : "";
                websiteApplicant = resultData.getString(6) != null ? resultData.getString(6) : "";
                constitutionApplicant = resultData.getString(7) != null ? resultData.getString(7) : "";
                dobApplicant = formatDate(resultData.getString(8) != null ? resultData.getString(8) : "");
                bussexpApplicant = resultData.getString(9) != null ? resultData.getString(9) : "";
                sreiexistingcustomerApplicant = resultData.getString(10) != null ? resultData.getString(10) : "";
                cibilscoreApplicant = resultData.getString(11) != null ? resultData.getString(11) : "";
                experianscoreApplicant = resultData.getString(12) != null ? resultData.getString(12) : "";
                equifaxscoreApplicant = resultData.getString(13) != null ? resultData.getString(13) : "";
                crifscoreApplicant = resultData.getString(14) != null ? resultData.getString(14) : "";
                cibilscorecommentsApplicant = resultData.getString(15) != null ? resultData.getString(15) : "";
                resifinumberApplicant = resultData.getString(16) != null ? resultData.getString(16) : "";
                resificommentsApplicant = resultData.getString(17) != null ? resultData.getString(17) : "";
                officefinumberApplicant = resultData.getString(18) != null ? resultData.getString(18) : "";
                officeficommentsApplicant = resultData.getString(19) != null ? resultData.getString(19) : "";
                residencestabilityApplicant = resultData.getString(20) != null ? resultData.getString(20) : "";
                residencestatusApplicant = resultData.getString(21) != null ? resultData.getString(21) : "";
                tvrdecisionApplicant = resultData.getString(22) != null ? resultData.getString(22) : "";
                tvrcommentsApplicant = resultData.getString(23) != null ? resultData.getString(23) : "";
                pslcategoryApplicant = resultData.getString(24) != null ? resultData.getString(24) : "";
                riskcategoryofcustomerApplicant = resultData.getString(25) != null ? resultData.getString(25) : "";
                riskcategorycustuserApplicant = resultData.getString(26) != null ? resultData.getString(26) : "";
                fleetsizeApplicant = resultData.getString(27) != null ? resultData.getString(27) : "";
                ratingagencyApplicant = resultData.getString(28) != null ? resultData.getString(28) : "";
                riskgradeApplicant = resultData.getString(29) != null ? resultData.getString(29) : "";
                Creditenhancement1Applicant = resultData.getString(30) != null ? resultData.getString(30) : "";
                agreewithratingsApplicant = resultData.getString(31) != null ? resultData.getString(31) : "";
                Creditenhancement2Applicant = resultData.getString(32) != null ? resultData.getString(32) : "";
                assetexperienceApplicant = resultData.getString(33) != null ? resultData.getString(33) : "";
                lengthofassociation_pdpApplicant = resultData.getString(34) != null ? resultData.getString(34) : "";
            }
        }catch (SQLException sqlEx){
            System.out.println("sqlEx: " + sqlEx);
        }catch (Exception e){
            System.out.println("e: " + e);
        }

        // Co-Applicant Query
        /////////////////////////////////// Query 8 /////////////////////////////////////////////////
        try{
            if(con==null){
                con = createConnection();
            }
            Statement stmt = con.createStatement();
            ResultSet resultData = null;
            String query8 = "select a.partyname, e.relationship relationship, d.address||' '||d.city||' '||d.state||' '||d.zipcode address," +
                    "d.mobilenum,d.emailadd,d.website,nvl(a.constitution,'NA') constitution, " +
                    "decode(a.customertype,'Individual',a.dob,a.dateofincorporation) dob," +
                    "(select e.detailtext from  cmplx_cam_miscellaneous e  where e.transactionno=b.transactionid and e.fieldname='Years of experience in Business') bussexp," +
                    "c.sreiexistingcustomer, e.cibilscore, e.experianscore, e.equifaxscore, e.crifscore," +
                    "e.scorecomments cibilscorecomments, e.internalfinumber resifinumber,c.fi_final_decision resificomments," +
                    "c.internalfinumber officefinumber,c.fi_final_decision officeficomments," +
                    "c.residencestability,c.residencestatus, c.tvrdecision, c.tvrcomments, c.pslcategory, " +
                    "c.riskcategoryofcustomer,c.riskcategorycustuser,c.fleetsize, c.crratingagency ratingagency, " +
                    "c.sefplclientgrading riskgrade, c.Creditenhancement1, c.agreewithratings,c.Creditenhancement2," +
                    "c.assetexperience, c.lengthofassociation_pdp" +
                    " from party_master a, ext_los_cam b, cmplx_cmeretail c, party_address_master d, CMPLX_CAM_RELATEDPARTY e \n" +
                    "where b.transactionid=e.transactionno(+) " +
                    "and a.partynumber=e.partynumber and upper(e.relationshiptype) like 'CO%' " +
                    "and a.partynumber=d.partynumber(+) " +
                    "and d.primarystatus(+)='Yes' " +
                    "and c.transactionno=b.transactionid " +
                    "and rownum<2 " +
                    "and b.transactionid='" + transactionId + "'";
            WFCallBroker.generateLog("GenResp", "query8: "+query8);
            System.out.println("query8: "+query8);
            resultData = stmt.executeQuery(query8);
            while (resultData.next()) {
                partynameCoApplicant = resultData.getString(1) != null ? resultData.getString(1) : "";
                relationshipCoApplicant = resultData.getString(2) != null ? resultData.getString(2) : "";
                addressCoApplicant = resultData.getString(3) != null ? resultData.getString(3) : "";
                mobilenumCoApplicant = resultData.getString(4) != null ? resultData.getString(4) : "";
                emailaddCoApplicant = resultData.getString(5) != null ? resultData.getString(5) : "";
                websiteCoApplicant = resultData.getString(6) != null ? resultData.getString(6) : "";
                constitutionCoApplicant = resultData.getString(7) != null ? resultData.getString(7) : "";
                dobCoApplicant = formatDate(resultData.getString(8) != null ? resultData.getString(8) : "");
                bussexpCoApplicant = resultData.getString(9) != null ? resultData.getString(9) : "";
                sreiexistingcustomerCoApplicant = resultData.getString(10) != null ? resultData.getString(10) : "";
                cibilscoreCoApplicant = resultData.getString(11) != null ? resultData.getString(11) : "";
                experianscoreCoApplicant = resultData.getString(12) != null ? resultData.getString(12) : "";
                equifaxscoreCoApplicant = resultData.getString(13) != null ? resultData.getString(13) : "";
                crifscoreCoApplicant = resultData.getString(14) != null ? resultData.getString(14) : "";
                cibilscorecommentsCoApplicant = resultData.getString(15) != null ? resultData.getString(15) : "";
                resifinumberCoApplicant = resultData.getString(16) != null ? resultData.getString(16) : "";
                resificommentsCoApplicant = resultData.getString(17) != null ? resultData.getString(17) : "";
                officefinumberCoApplicant = resultData.getString(18) != null ? resultData.getString(18) : "";
                officeficommentsCoApplicant = resultData.getString(19) != null ? resultData.getString(19) : "";
                residencestabilityCoApplicant = resultData.getString(20) != null ? resultData.getString(20) : "";
                residencestatusCoApplicant = resultData.getString(21) != null ? resultData.getString(21) : "";
                tvrdecisionCoApplicant = resultData.getString(22) != null ? resultData.getString(22) : "";
                tvrcommentsCoApplicant = resultData.getString(23) != null ? resultData.getString(23) : "";
                pslcategoryCoApplicant = resultData.getString(24) != null ? resultData.getString(24) : "";
                riskcategoryofcustomerCoApplicant = resultData.getString(25) != null ? resultData.getString(25) : "";
                riskcategorycustuserCoApplicant = resultData.getString(26) != null ? resultData.getString(26) : "";
                fleetsizeCoApplicant = resultData.getString(27) != null ? resultData.getString(27) : "";
                ratingagencyCoApplicant = resultData.getString(28) != null ? resultData.getString(28) : "";
                riskgradeCoApplicant = resultData.getString(29) != null ? resultData.getString(29) : "";
                Creditenhancement1CoApplicant = resultData.getString(30) != null ? resultData.getString(30) : "";
                agreewithratingsCoApplicant = resultData.getString(31) != null ? resultData.getString(31) : "";
                Creditenhancement2CoApplicant = resultData.getString(32) != null ? resultData.getString(32) : "";
                assetexperienceCoApplicant = resultData.getString(33) != null ? resultData.getString(33) : "";
                lengthofassociation_pdpCoApplicant = resultData.getString(34) != null ? resultData.getString(34) : "";
            }
        }catch (SQLException sqlEx){
            System.out.println("sqlEx: " + sqlEx);
        }catch (Exception e){
            System.out.println("e: " + e);
        }

        // Guarantor Query
        /////////////////////////////////// Query 9 /////////////////////////////////////////////////
        try{
            if(con==null){
                con = createConnection();
            }
            Statement stmt = con.createStatement();
            ResultSet resultData = null;
            String query9 = "select a.partyname, e.relationship relationship, d.address||' '||d.city||' '||d.state||' '||d.zipcode address," +
                    "d.mobilenum,d.emailadd,d.website, nvl(a.constitution,'NA') constitution, " +
                    "decode(a.customertype,'Individual',a.dob,a.dateofincorporation) dob, " +
                    "(select e.detailtext from  cmplx_cam_miscellaneous e  where e.transactionno=b.transactionid and e.fieldname='Years of experience in Business') bussexp," +
                    "c.sreiexistingcustomer, e.cibilscore, e.experianscore, e.equifaxscore, e.crifscore," +
                    "e.scorecomments cibilscorecomments, e.internalfinumber resifinumber,c.fi_final_decision resificomments," +
                    "c.internalfinumber officefinumber,c.fi_final_decision officeficomments,c.residencestability," +
                    "c.residencestatus, c.tvrdecision, c.tvrcomments, c.pslcategory, c.riskcategoryofcustomer," +
                    "c.riskcategorycustuser,c.fleetsize, c.crratingagency ratingagency, c.sefplclientgrading riskgrade, " +
                    "c.Creditenhancement1, c.agreewithratings,c.Creditenhancement2," +
                    "c.assetexperience, c.lengthofassociation_pdp,e.relationshiptype " +
                    "from party_master a, ext_los_cam b, cmplx_cmeretail c, party_address_master d, CMPLX_CAM_RELATEDPARTY e " +
                    "where b.transactionid=e.transactionno(+) " +
                    "and a.partynumber=e.partynumber and upper(e.relationshiptype) like 'GUA%' " +
                    "and a.partynumber=d.partynumber(+) " +
                    "and d.primarystatus(+)='Yes' " +
                    "and c.transactionno=b.transactionid " +
                    "and rownum<2 " +
                    "and b.transactionid='" + transactionId + "'";
            WFCallBroker.generateLog("GenResp", "query9: "+query9);
            System.out.println("query9: "+query9);
            resultData = stmt.executeQuery(query9);
            while (resultData.next()) {
                partynameGuarantor = resultData.getString(1) != null ? resultData.getString(1) : "";
                relationshipGuarantor = resultData.getString(2) != null ? resultData.getString(2) : "";
                addressGuarantor = resultData.getString(3) != null ? resultData.getString(3) : "";
                mobilenumGuarantor = resultData.getString(4) != null ? resultData.getString(4) : "";
                emailaddGuarantor = resultData.getString(5) != null ? resultData.getString(5) : "";
                websiteGuarantor = resultData.getString(6) != null ? resultData.getString(6) : "";
                constitutionGuarantor = resultData.getString(7) != null ? resultData.getString(7) : "";
                dobGuarantor = formatDate(resultData.getString(8) != null ? resultData.getString(8) : "");
                bussexpGuarantor = resultData.getString(9) != null ? resultData.getString(9) : "";
                sreiexistingcustomerGuarantor = resultData.getString(10) != null ? resultData.getString(10) : "";
                cibilscoreGuarantor = resultData.getString(11) != null ? resultData.getString(11) : "";
                experianscoreGuarantor = resultData.getString(12) != null ? resultData.getString(12) : "";
                equifaxscoreGuarantor = resultData.getString(13) != null ? resultData.getString(13) : "";
                crifscoreGuarantor = resultData.getString(14) != null ? resultData.getString(14) : "";
                cibilscorecommentsGuarantor = resultData.getString(15) != null ? resultData.getString(15) : "";
                resifinumberGuarantor = resultData.getString(16) != null ? resultData.getString(16) : "";
                resificommentsGuarantor = resultData.getString(17) != null ? resultData.getString(17) : "";
                officefinumberGuarantor = resultData.getString(18) != null ? resultData.getString(18) : "";
                officeficommentsGuarantor = resultData.getString(19) != null ? resultData.getString(19) : "";
                residencestabilityGuarantor = resultData.getString(20) != null ? resultData.getString(20) : "";
                residencestatusGuarantor = resultData.getString(21) != null ? resultData.getString(21) : "";
                tvrdecisionGuarantor = resultData.getString(22) != null ? resultData.getString(22) : "";
                tvrcommentsGuarantor = resultData.getString(23) != null ? resultData.getString(23) : "";
                pslcategoryGuarantor = resultData.getString(24) != null ? resultData.getString(24) : "";
                riskcategoryofcustomerGuarantor = resultData.getString(25) != null ? resultData.getString(25) : "";
                riskcategorycustuserGuarantor = resultData.getString(26) != null ? resultData.getString(26) : "";
                fleetsizeGuarantor = resultData.getString(27) != null ? resultData.getString(27) : "";
                ratingagencyGuarantor = resultData.getString(28) != null ? resultData.getString(28) : "";
                riskgradeGuarantor = resultData.getString(29) != null ? resultData.getString(29) : "";
                Creditenhancement1Guarantor = resultData.getString(30) != null ? resultData.getString(30) : "";
                agreewithratingsGuarantor = resultData.getString(31) != null ? resultData.getString(31) : "";
                Creditenhancement2Guarantor = resultData.getString(32) != null ? resultData.getString(32) : "";
                assetexperienceGuarantor = resultData.getString(33) != null ? resultData.getString(33) : "";
                lengthofassociation_pdpGuarantor = resultData.getString(34) != null ? resultData.getString(34) : "";
                relationshiptypeGuarantor = resultData.getString(35) != null ? resultData.getString(35) : "";
            }
        }catch (SQLException sqlEx){
            System.out.println("sqlEx: " + sqlEx);
        }catch (Exception e){
            System.out.println("e: " + e);
        }

        // Block C and E
        /////////////////////////////////// Query 10 /////////////////////////////////////////////////
        try{
            if(con==null){
                con = createConnection();
            }
            Statement stmt = con.createStatement();
            ResultSet resultData = null;
            String query10 = "select a.natureofwork, a.businessbackground, a.gurantorbackground, a.majorprincipal," +
                    "a.proposedassets, a.existingassetscomment, a.coapplicantprofile," +
                    "a.group_profile,a.assethistory, a.quippovaluationreport,a.existingexposurecomment," +
                    "a.existingexposureconduct, a.viabilitycalculation, a.foirresult,a.foir, a.inhandcontractcomment," +
                    "a.commentfinancialhighlights, a.particulars, a.dscr, a.acr, a.externalliabilitycomment, a.periodfrom, a.periodto," +
                    "round(a.totalbillingamt/100000,2) totalbilling, round(a.paymentreceived/100000,2) totalpaymentreceived," +
                    "a.currentyearworking, a.portfoliosnapshot, a.exposuredetailcomment " +
                    "from Cmplx_Cmeretail a where a.transactionno= '" + transactionId + "'";
            WFCallBroker.generateLog("GenResp", "query10: "+query10);
            System.out.println("query10: "+query10);
            resultData = stmt.executeQuery(query10);
            while (resultData.next()) {
                natureofwork = resultData.getString(1) != null ? resultData.getString(1) : "";
                businessbackground = resultData.getString(2) != null ? resultData.getString(2) : "";
                gurantorbackground = resultData.getString(3) != null ? resultData.getString(3) : "";
                majorprincipal = resultData.getString(4) != null ? resultData.getString(4) : "";
                proposedassets = resultData.getString(5) != null ? resultData.getString(5) : "";
                existingassetscomment = resultData.getString(6) != null ? resultData.getString(6) : "";
                coapplicantprofile = resultData.getString(7) != null ? resultData.getString(7) : "";
                group_profile = resultData.getString(8) != null ? resultData.getString(8) : "";
                assethistory = resultData.getString(9) != null ? resultData.getString(9) : "";
                quippovaluationreport = resultData.getString(10) != null ? resultData.getString(10) : "";
                existingexposurecomment = resultData.getString(11) != null ? resultData.getString(11) : "";
                existingexposureconduct = resultData.getString(12) != null ? resultData.getString(12) : "";
                viabilitycalculation = resultData.getString(13) != null ? resultData.getString(13) : "";
                foirresult = resultData.getString(14) != null ? resultData.getString(14) : "";
                foir = resultData.getString(15) != null ? resultData.getString(15) : "";
                inhandcontractcomment = resultData.getString(16) != null ? resultData.getString(16) : "";
                commentfinancialhighlights = resultData.getString(17) != null ? resultData.getString(17) : "";
                particulars = resultData.getString(18) != null ? resultData.getString(18) : "";
                dscr = resultData.getString(19) != null ? resultData.getString(19) : "";
                acr = resultData.getString(20) != null ? resultData.getString(20) : "";
                externalliabilitycomment = resultData.getString(21) != null ? resultData.getString(21) : "";
                periodfrom = formatDate(resultData.getString(22) != null ? resultData.getString(22) : "");
                periodto = formatDate(resultData.getString(23) != null ? resultData.getString(23) : "");
                totalbilling = resultData.getString(24) != null ? resultData.getString(24) : "";
                totalpaymentreceived = resultData.getString(25) != null ? resultData.getString(25) : "";
                currentyearworking = resultData.getString(26) != null ? resultData.getString(26) : "";
                portfoliosnapshot = resultData.getString(27) != null ? resultData.getString(27) : "";
                exposuredetailcomment = resultData.getString(27) != null ? resultData.getString(27) : "";
            }
        }catch (SQLException sqlEx){
            System.out.println("sqlEx: " + sqlEx);
        }catch (Exception e){
            System.out.println("e: " + e);
        }

        // Policy LTV
        /////////////////////////////////// Query 11 /////////////////////////////////////////////////
        try{
            if(con==null){
                con = createConnection();
            }
            Statement stmt = con.createStatement();
            ResultSet resultData = null;
            String query11 = "select nvl(max(b.endrangeltvvalue),80) polltv from ext_los_cam a, APPROVAL_ROUTING_CME_EQUIK b " +
                    "where a.transactionid= '" + transactionId + "' " +
                    "and a.business_vertical=b.businessvertical " +
                    "and upper(a.classification)=b.customerclassification " +
                    "and upper(a.model)=b.businessmodel " +
                    "and upper(a.branchcategory)=b.branchcategory " +
                    "and a.sanctionedexposure<=b.endexposurevalue";
            WFCallBroker.generateLog("GenResp", "query11: "+query11);
            System.out.println("query11: "+query11);
            resultData = stmt.executeQuery(query11);
            while (resultData.next()) {
                polltv = resultData.getString(1) != null ? resultData.getString(1) : "";
            }
        }catch (SQLException sqlEx){
            System.out.println("sqlEx: " + sqlEx);
        }catch (Exception e){
            System.out.println("e: " + e);
        }

        // Policy Tenure
        /////////////////////////////////// Query 12 /////////////////////////////////////////////////
        try{
            if(con==null){
                con = createConnection();
            }
            Statement stmt = con.createStatement();
            ResultSet resultData = null;
            String query12 = "select nvl(max(b.ENDRANGETENUREVALUE),36) polten from ext_los_cam a, APPROVAL_ROUTING_CME_EQUIK b  " +
                    "where a.transactionid= '" + transactionId + "' " +
                    "and a.business_vertical=b.businessvertical " +
                    "and upper(a.classification)=b.customerclassification " +
                    "and upper(a.model)=b.businessmodel " +
                    "and upper(a.branchcategory)=b.branchcategory " +
                    "and a.sanctionedexposure<=b.endexposurevalue";
            WFCallBroker.generateLog("GenResp", "query12: "+query12);
            System.out.println("query12: "+query12);
            resultData = stmt.executeQuery(query12);
            while (resultData.next()) {
                polten = resultData.getString(1) != null ? resultData.getString(1) : "";
            }
        }catch (SQLException sqlEx){
            System.out.println("sqlEx: " + sqlEx);
        }catch (Exception e){
            System.out.println("e: " + e);
        }

        // Pro Ltv
        /////////////////////////////////// Query 13 /////////////////////////////////////////////////
        try{
            if(con==null){
                con = createConnection();
            }
            Statement stmt = con.createStatement();
            ResultSet resultData = null;
            String query13 = "select round(sum(round(a.financeamt/100000,2))/sum(round(a.assetcost/100000,2))*100,2) proLTV " +
                    "from cmplx_cam_assetdetails a " +
                    "where a.transactionno= '" + transactionId + "'";
            WFCallBroker.generateLog("GenResp", "\nquery13: "+query13+"\n");
            System.out.println("query13: "+query13);
            resultData = stmt.executeQuery(query13);
            while (resultData.next()) {
                proltv = resultData.getString(1) != null ? resultData.getString(1) : "";
                WFCallBroker.generateLog("GenResp", "\nbhanu proltv: "+proltv+"\n");
            }
        }catch (SQLException sqlEx){
            System.out.println("sqlEx: " + sqlEx);
        }catch (Exception e){
            System.out.println("e: " + e);
        }

        // Pro Tenure
        /////////////////////////////////// Query 14 /////////////////////////////////////////////////
        try{
            if(con==null){
                con = createConnection();
            }
            Statement stmt = con.createStatement();
            ResultSet resultData = null;
            String query14 = "select c.tenure " +
                    "from cmplx_cam_assetdetails a, asset_master b, CMPLX_CAM_QUOTESATTACH c, ext_los_cam d  " +
                    "where a.assetname=b.assetname " +
                    "and a.transactionno=c.transactionno " +
                    "and a.transactionno=d.transactionid " +
                    "and a.transactionno= '" + transactionId + "'";
            WFCallBroker.generateLog("GenResp", "query14: "+query14);
            System.out.println("query14: "+query14);
            resultData = stmt.executeQuery(query14);
            while (resultData.next()) {
                protenure = resultData.getString(1) != null ? resultData.getString(1) : "";
            }
        }catch (SQLException sqlEx){
            System.out.println("sqlEx: " + sqlEx);
        }catch (Exception e){
            System.out.println("e: " + e);
        }

        // FFR Result
        /////////////////////////////////// Query 15 /////////////////////////////////////////////////
        try{
            if(con==null){
                con = createConnection();
            }
            Statement stmt = con.createStatement();
            ResultSet resultData = null;
            String query15 = "select a.totalfleet, a.totalfleetfinance, a.freefleet, a.frrresult ffr, a.ffr ffrcomments " +
                    "from Cmplx_Cmeretail a where a.transactionno= '" + transactionId + "'";
            WFCallBroker.generateLog("GenResp", "\nquery15: " + query15);
            System.out.println("query15: "+query15);
            resultData = stmt.executeQuery(query15);
            WFCallBroker.generateLog("GenResp", "resultData: "+resultData);
            while (resultData.next()) {
                totalfleet = resultData.getString(1) != null ? resultData.getString(1) : "";
                totalfleetfinance = resultData.getString(2) != null ? resultData.getString(2) : "";
                freefleet = resultData.getString(3) != null ? resultData.getString(3) : "";
                ffr = resultData.getString(4) != null ? resultData.getString(4) : "";
                ffrcomments = resultData.getString(5) != null ? resultData.getString(5) : "";
            }
        }catch (SQLException sqlEx){
            System.out.println("sqlEx: " + sqlEx);
        }catch (Exception e){
            System.out.println("e: " + e);
        }

        // Credit Comments - overall_comments
        /////////////////////////////////// Query 16 /////////////////////////////////////////////////
        try{
            if(con==null){
                con = createConnection();
            }
            Statement stmt = con.createStatement();
            ResultSet resultData = null;
            String query16 = "select a.remarks overall_comment from CMPLX_CAM_COMMENT a where a.transactionno= '" + transactionId + "'" +
                    "and a.grade='Overall Comment'";
            WFCallBroker.generateLog("GenResp", "\nquery16: " + query16);
            System.out.println("query16: "+query16);
            resultData = stmt.executeQuery(query16);
            WFCallBroker.generateLog("GenResp", "resultData: "+resultData);
            while (resultData.next()) {
                overall_comment = resultData.getString(1) != null ? resultData.getString(1) : "";
            }
        }catch (SQLException sqlEx){
            System.out.println("sqlEx: " + sqlEx);
        }catch (Exception e){
            System.out.println("e: " + e);
        }

        // Credit Comments - strenghts
        /////////////////////////////////// Query 17 /////////////////////////////////////////////////
        try{
            if(con==null){
                con = createConnection();
            }
            Statement stmt = con.createStatement();
            ResultSet resultData = null;
            String query17 = "select a.remarks Strenghts from CMPLX_CAM_COMMENT a " +
                    "where a.transactionno= '" + transactionId + "' and a.grade='Strenghts'";
            WFCallBroker.generateLog("GenResp", "\nquery17: " + query17);
            System.out.println("query17: "+query17);
            resultData = stmt.executeQuery(query17);
            WFCallBroker.generateLog("GenResp", "resultData: "+resultData);
            while (resultData.next()) {
                strenghts = resultData.getString(1) != null ? resultData.getString(1) : "";
            }
        }catch (SQLException sqlEx){
            System.out.println("sqlEx: " + sqlEx);
        }catch (Exception e){
            System.out.println("e: " + e);
        }

        // Credit Comments - concerns
        /////////////////////////////////// Query 18 /////////////////////////////////////////////////
        try{
            if(con==null){
                con = createConnection();
            }
            Statement stmt = con.createStatement();
            ResultSet resultData = null;
            String query18 = "select a.remarks Concerns from CMPLX_CAM_COMMENT a " +
                    "where a.transactionno= '" + transactionId + "' and a.grade='Concerns'";
            WFCallBroker.generateLog("GenResp", "\nquery18: " + query18);
            System.out.println("query18: "+query18);
            resultData = stmt.executeQuery(query18);
            WFCallBroker.generateLog("GenResp", "resultData: "+resultData);
            while (resultData.next()) {
                concerns = resultData.getString(1) != null ? resultData.getString(1) : "";
            }
        }catch (SQLException sqlEx){
            System.out.println("sqlEx: " + sqlEx);
        }catch (Exception e){
            System.out.println("e: " + e);
        }

        // Credit Comments - finalrecommendation
        /////////////////////////////////// Query 19 /////////////////////////////////////////////////
        try{
            if(con==null){
                con = createConnection();
            }
            Statement stmt = con.createStatement();
            ResultSet resultData = null;
            String query19 = "select a.remarks FinalRecommendation from CMPLX_CAM_COMMENT a " +
                    "where a.transactionno= '" + transactionId + "' and a.grade='Final Recommendation'";
            WFCallBroker.generateLog("GenResp", "\nquery19: " + query19);
            System.out.println("query19: "+query19);
            resultData = stmt.executeQuery(query19);
            WFCallBroker.generateLog("GenResp", "resultData: "+resultData);
            while (resultData.next()) {
                finalrecommendation = resultData.getString(1) != null ? resultData.getString(1) : "";
            }
        }catch (SQLException sqlEx){
            System.out.println("sqlEx: " + sqlEx);
        }catch (Exception e){
            System.out.println("e: " + e);
        }

        // assetCategory
        /////////////////////////////////// Query 20 /////////////////////////////////////////////////
        try{
            if(con==null){
                con = createConnection();
            }
            Statement stmt = con.createStatement();
            ResultSet resultData = null;
            String query20 = "select listagg(b.asset_segment,',') within group(order by asset_segment) asset_category " +
                    "from cmplx_cam_assetdetails a, asset_master b " +
                    "where a.assetname=b.assetname " +
                    "and a.transactionno= '" + transactionId + "'";
            WFCallBroker.generateLog("GenResp", "\nquery20: " + query20);
            System.out.println("query20: "+query20);
            resultData = stmt.executeQuery(query20);
            WFCallBroker.generateLog("GenResp", "resultData: "+resultData);
            while (resultData.next()) {
                assetCategory = resultData.getString(1) != null ? resultData.getString(1) : "";
            }
        }catch (SQLException sqlEx){
            System.out.println("sqlEx: " + sqlEx);
        }catch (Exception e){
            System.out.println("e: " + e);
        }

        if(polltv !=null && !polltv.equalsIgnoreCase("")){
            try{
                polltvDouble = Double.parseDouble(polltv);
            }catch (NumberFormatException nfe){
                System.out.println("nfe1: " + nfe);
            }
        }
        if(proltv !=null && !proltv.equalsIgnoreCase("")){
            try{
                proltvDouble = Double.parseDouble(proltv);
            }catch (NumberFormatException nfe){
                System.out.println("nfe2: " + nfe);
            }
        }
        if(polten !=null && !polten.equalsIgnoreCase("")){
            try{
                poltenDouble = Double.parseDouble(polten);
            }catch (NumberFormatException nfe){
                System.out.println("nfe3: " + nfe);
            }
        }
        if(protenure !=null && !protenure.equalsIgnoreCase("")){
            try{
                protenureDouble = Double.parseDouble(protenure);
            }catch (NumberFormatException nfe){
                System.out.println("nfe4: " + nfe);
            }
        }
        variationInLtv = String.valueOf(proltvDouble - polltvDouble);
        variationInTenure = String.valueOf(protenureDouble - poltenDouble);
        closeDbConnection();
    }

    public void setTabularData(){

        // Trade Reference
        /////////////////////////////////// Query A /////////////////////////////////////////////////
        try{
            con = createConnection();
            Statement stmt = con.createStatement();
            ResultSet resultData = null;
            String queryA = "select a.personname, a.contactno, a.detailreference, a.relationship, a.referencecheck, " +
                    "a.remarks from CMPLX_CAM_TRADEREF a where a.transactionno='" + transactionId + "'";
            WFCallBroker.generateLog("GenResp", "\nqueryA: "+queryA);
            System.out.println("queryA: "+queryA);
            resultData = stmt.executeQuery(queryA);
            WFCallBroker.generateLog("GenResp", "resultData: "+resultData);
            while (resultData.next()) {
                ArrayList<String> inner = new ArrayList<String>();
                inner.add(resultData.getString(1) != null ? resultData.getString(1) : "");
                inner.add(resultData.getString(2) != null ? resultData.getString(2) : "");
                inner.add(resultData.getString(3) != null ? resultData.getString(3) : "");
                inner.add(resultData.getString(4) != null ? resultData.getString(4) : "");
                inner.add(resultData.getString(5) != null ? resultData.getString(5) : "");
                inner.add(resultData.getString(6) != null ? resultData.getString(6) : "");
                tradeReferenceList.add(inner);
            }
        }catch (SQLException sqlEx){
            System.out.println("sqlEx: " + sqlEx);
        }catch (Exception e){
            System.out.println("e: " + e);
        }

        // Facility Required
        /////////////////////////////////// Query B - I /////////////////////////////////////////////////
        try{
            if(con==null){
                con = createConnection();
            }
            Statement stmt = con.createStatement();
            ResultSet resultData = null;
            String queryB = "select a.assetname, a.regassetnumber, b.model, a.quantity, round(a.assetcost/100000,2) assetcost, " +
                    "decode(d.business_model_new,'Vendor','NA',round(nvl(a.assetassumevaluation,0)/100000,2)) quippovalue, " +
                    "decode(d.business_model_new,'Vendor','NA',round(nvl(a.gridvalue,0)/100000,2)) gridvalue, " +
                    "decode(d.business_model_new,'Vendor','NA',round(nvl(a.idv_value,0)/100000,2)) idvvalue, " +
                    "round((c.financeamt/c.totassetcost)*100,2) LTV, round(c.financeamt/100000,2) financeamt, " +
                    "c.airr irrpersent,c.tenure, c.moratorium, b.asset_segment  " +
                    "from cmplx_cam_assetdetails a, asset_master b, CMPLX_CAM_QUOTESATTACH c, ext_los_cam d  " +
                    "where a.assetname=b.assetname " +
                    "and a.transactionno=c.transactionno " +
                    "and a.transactionno=d.transactionid " +
                    "and a.transactionno= '" + transactionId + "'";
            WFCallBroker.generateLog("GenResp", "\nqueryB: "+queryB);
            System.out.println("queryB: "+queryB);
            resultData = stmt.executeQuery(queryB);
            WFCallBroker.generateLog("GenResp", "resultData: "+resultData);
            while (resultData.next()) {
                ArrayList<String> inner = new ArrayList<String>();
                inner.add(resultData.getString(1) != null ? resultData.getString(1) : "");
                inner.add(resultData.getString(2) != null ? resultData.getString(2) : "");
                inner.add(resultData.getString(3) != null ? resultData.getString(3) : "");
                inner.add(resultData.getString(4) != null ? resultData.getString(4) : "");
                inner.add(resultData.getString(5) != null ? resultData.getString(5) : "");
                inner.add(resultData.getString(6) != null ? resultData.getString(6) : "");
                inner.add(resultData.getString(7) != null ? resultData.getString(7) : "");
                inner.add(resultData.getString(8) != null ? resultData.getString(8) : "");
                inner.add(resultData.getString(9) != null ? resultData.getString(9) : "");
                inner.add(resultData.getString(10) != null ? resultData.getString(10) : "");
                inner.add(resultData.getString(11) != null ? resultData.getString(11) : "");
                inner.add(resultData.getString(12) != null ? resultData.getString(12) : "");
                inner.add(resultData.getString(13) != null ? resultData.getString(13) : "");
                inner.add(resultData.getString(14) != null ? resultData.getString(14) : "");
                facilityRequiredList.add(inner);
            }
        }catch (SQLException sqlEx){
            System.out.println("sqlEx: " + sqlEx);
        }catch (Exception e){
            System.out.println("e: " + e);
        }

        // Facility Required Total
        /////////////////////////////////// Query B - II /////////////////////////////////////////////////
        if(facilityRequiredList.size() > 0){
            try{
                if(con==null){
                    con = createConnection();
                }
                Statement stmt = con.createStatement();
                ResultSet resultData = null;
                String queryB = "select sum(a.quantity) totalquantity, sum(round(a.assetcost/100000,2)) totalassetcost, " +
                        "sum(round(nvl(a.assetassumevaluation,0)/100000,2)) totalquippovalue, " +
                        "sum(round(nvl(a.gridvalue,0)/100000,2)) totalgridvalue, sum(round(nvl(a.idv_value,0)/100000,2)) totalidvvalue," +
                        "sum(round(a.financeamt/100000,2)) totalfinanceamt " +
                        "from cmplx_cam_assetdetails a " +
                        "where a.transactionno= '" + transactionId + "'";
                WFCallBroker.generateLog("GenResp", "\nqueryB: "+queryB);
                System.out.println("queryB: "+queryB);
                resultData = stmt.executeQuery(queryB);
                WFCallBroker.generateLog("GenResp", "resultData: "+resultData);
                while (resultData.next()) {
                    ArrayList<String> inner = new ArrayList<String>();
                    inner.add("Total");
                    inner.add("");
                    inner.add("");
                    inner.add(resultData.getString(1) != null ? resultData.getString(1) : "");
                    inner.add(resultData.getString(2) != null ? resultData.getString(2) : "");
                    inner.add(resultData.getString(3) != null ? resultData.getString(3) : "");
                    inner.add(resultData.getString(4) != null ? resultData.getString(4) : "");
                    inner.add(resultData.getString(5) != null ? resultData.getString(5) : "");
                    inner.add("");
                    inner.add(resultData.getString(6) != null ? resultData.getString(6) : "");
                    inner.add("");
                    inner.add("");
                    inner.add("");
                    inner.add("");
                    facilityRequiredList.add(inner);
                }
            }catch (SQLException sqlEx){
                System.out.println("sqlEx: " + sqlEx);
            }catch (Exception e){
                System.out.println("e: " + e);
            }
        }

        // Exposure Details
        /////////////////////////////////// Query B - III /////////////////////////////////////////////////
        try{
            if(con==null){
                con = createConnection();
            }
            Statement stmt = con.createStatement();
            ResultSet resultData = null;
            String queryB = "select a.particulars, a.expclient client, a.guarantor, a.expgroup groupexposure, a.exptotal " +
                    "from CMPLX_CAMEXPOSUREDETAILS a where a.transactionno= '" + transactionId + "' order by a.insertionorderid";
            WFCallBroker.generateLog("GenResp", "\nqueryC: " + queryB);
            System.out.println("queryB: "+queryB);
            resultData = stmt.executeQuery(queryB);
            WFCallBroker.generateLog("GenResp", "resultData: "+resultData);
            while (resultData.next()) {
                ArrayList<String> inner = new ArrayList<String>();
                inner.add(resultData.getString(1) != null ? resultData.getString(1) : "");
                inner.add(resultData.getString(2) != null ? resultData.getString(2) : "");
                inner.add(resultData.getString(3) != null ? resultData.getString(3) : "");
                inner.add(resultData.getString(4) != null ? resultData.getString(4) : "");
                inner.add(resultData.getString(5) != null ? resultData.getString(5) : "");
                exposureDetailsList.add(inner);
            }
        }catch (SQLException sqlEx){
            System.out.println("sqlEx: " + sqlEx);
        }catch (Exception e){
            System.out.println("e: " + e);
        }

        // Management/Ownership
        /////////////////////////////////// Query D /////////////////////////////////////////////////
        try{
            if(con==null){
                con = createConnection();
            }
            Statement stmt = con.createStatement();
            ResultSet resultData = null;
            String queryD = "select a.partyname,a.holding,a.relationship,decode(b.customertype,'Individual',b.dob," +
                    "b.dateofincorporation) DOB_DOI,a.cibilscore from cmplx_cam_relatedparty a,party_master b " +
                    "where a.partynumber=b.partynumber " +
                    "and a.relationshiptype<>'Others' " +
                    "and a.transactionno='" + transactionId + "' union " +
                    "select a.partyname,a.holding,a.relationship,a.dob DOB_DOI,a.cibilscore from cmplx_cam_relatedparty a " +
                    "where a.relationshiptype='Others' " +
                    "and a.transactionno='" + transactionId + "'";
            WFCallBroker.generateLog("GenResp", "\nqueryD: " + queryD);
            System.out.println("queryD: "+queryD);
            resultData = stmt.executeQuery(queryD);
            WFCallBroker.generateLog("GenResp", "resultData: "+resultData);
            while (resultData.next()) {
                ArrayList<String> inner = new ArrayList<String>();
                inner.add(resultData.getString(1) != null ? resultData.getString(1) : "");
                inner.add(resultData.getString(2) != null ? resultData.getString(2) : "");
                inner.add(resultData.getString(3) != null ? resultData.getString(3) : "");
                inner.add(formatDate(resultData.getString(4) != null ? resultData.getString(4) : ""));
                inner.add(resultData.getString(5) != null ? resultData.getString(5) : "");
                managementOwnershipList.add(inner);
            }
        }catch (SQLException sqlEx){
            System.out.println("sqlEx: " + sqlEx);
        }catch (Exception e){
            System.out.println("e: " + e);
        }

        // List of Construction Equipment
        /////////////////////////////////// Query F - I /////////////////////////////////////////////////
        try{
            if(con==null){
                con = createConnection();
            }
            Statement stmt = con.createStatement();
            ResultSet resultData = null;
            String queryF = "select a.assetowner, a.equipmenttype, a.modelno, a.yearmfg, a.reginvoiceno, a.ownershiptype frrefinance, " +
                    "a.nameoffinancier, a.fallenortenure, a.peakdelayoravgdelay " +
                    "from CMPLX_CAM_EXISTINGASSET a where a.transactionno= '" + transactionId + "'";
            WFCallBroker.generateLog("GenResp", "\nqueryF: " + queryF);
            System.out.println("queryF: "+queryF);
            resultData = stmt.executeQuery(queryF);
            WFCallBroker.generateLog("GenResp", "resultData: "+resultData);
            while (resultData.next()) {
                ArrayList<String> inner = new ArrayList<String>();
                inner.add(resultData.getString(1) != null ? resultData.getString(1) : "");
                inner.add(resultData.getString(2) != null ? resultData.getString(2) : "");
                inner.add(resultData.getString(3) != null ? resultData.getString(3) : "");
                inner.add(getStringWithoutDecimalPart(resultData.getString(4) != null ? resultData.getString(4) : ""));
                inner.add(resultData.getString(5) != null ? resultData.getString(5) : "");
                inner.add(resultData.getString(6) != null ? resultData.getString(6) : "");
                inner.add(resultData.getString(7) != null ? resultData.getString(7) : "");
                inner.add(resultData.getString(8) != null ? resultData.getString(8) : "");
                inner.add(resultData.getString(9) != null ? resultData.getString(9) : "");
                constructionEquipmentList.add(inner);
            }
        }catch (SQLException sqlEx){
            System.out.println("sqlEx: " + sqlEx);
        }catch (Exception e){
            System.out.println("e: " + e);
        }

        // Existing Exposure with SREI
        /////////////////////////////////// Query G - I/////////////////////////////////////////////////
        try{
            if(con==null){
                con = createConnection();
            }
            Statement stmt = con.createStatement();
            ResultSet resultData = null;
            String queryG = "select a.assetowner, a.assetfunded, a.contractnumber, a.year, a.assetcost, a.financeamount, " +
                    "a.pos, a.totaloutstanding, a.tenor, a.peakaveragedelay, a.sreigridvalue, a.dpd, a.alg " +
                    "from CMPLX_CAM_EXPOSURE a " +
                    "where a.transactionno= '" + transactionId + "'";
            WFCallBroker.generateLog("GenResp", "\nqueryG: " + queryG);
            System.out.println("queryG: "+queryG);
            resultData = stmt.executeQuery(queryG);
            WFCallBroker.generateLog("GenResp", "resultData: "+resultData);
            while (resultData.next()) {
                ArrayList<String> inner = new ArrayList<String>();
                inner.add(resultData.getString(1) != null ? resultData.getString(1) : "");
                inner.add(resultData.getString(2) != null ? resultData.getString(2) : "");
                inner.add(resultData.getString(3) != null ? resultData.getString(3) : "");
                inner.add(resultData.getString(4) != null ? resultData.getString(4) : "");
                inner.add(resultData.getString(5) != null ? resultData.getString(5) : "");
                inner.add(resultData.getString(6) != null ? resultData.getString(6) : "");
                inner.add(resultData.getString(7) != null ? resultData.getString(7) : "");
                inner.add(resultData.getString(8) != null ? resultData.getString(8) : "");
                inner.add(resultData.getString(9) != null ? resultData.getString(9) : "");
                inner.add(resultData.getString(10) != null ? resultData.getString(10) : "");
                inner.add(resultData.getString(11) != null ? resultData.getString(11) : "");
                inner.add(resultData.getString(12) != null ? resultData.getString(12) : "");
                inner.add(resultData.getString(13) != null ? resultData.getString(13) : "");
                existingExposureWithSreiList.add(inner);
            }
        }catch (SQLException sqlEx){
            System.out.println("sqlEx: " + sqlEx);
        }catch (Exception e){
            System.out.println("e: " + e);
        }

        // Existing Exposure with SREI Total
        /////////////////////////////////// Query G - II/////////////////////////////////////////////////
        if(existingExposureWithSreiList.size() > 0){
            try{
                if(con==null){
                    con = createConnection();
                }
                Statement stmt = con.createStatement();
                ResultSet resultData = null;
                String queryG = "select sum(assetcost) totalassetcost, sum(financeamount) totalfinanceamount,sum(pos) totalpos, " +
                        "sum(totaloutstanding) totaltotaloutstanding, sum(sreigridvalue) totsreigridvalue " +
                        "from CMPLX_CAM_EXPOSURE a " +
                        "where a.transactionno= '" + transactionId + "'";
                WFCallBroker.generateLog("GenResp", "\nqueryG: " + queryG);
                System.out.println("queryG: "+queryG);
                resultData = stmt.executeQuery(queryG);
                WFCallBroker.generateLog("GenResp", "resultData: "+resultData);
                while (resultData.next()) {
                    ArrayList<String> inner = new ArrayList<String>();
                    inner.add("Total");
                    inner.add("");
                    inner.add("");
                    inner.add("");
                    inner.add(resultData.getString(1) != null ? resultData.getString(1) : "");
                    inner.add(resultData.getString(2) != null ? resultData.getString(2) : "");
                    inner.add(resultData.getString(3) != null ? resultData.getString(3) : "");
                    inner.add(resultData.getString(4) != null ? resultData.getString(4) : "");
                    inner.add("");
                    inner.add("");
                    inner.add(resultData.getString(5) != null ? resultData.getString(5) : "");
                    inner.add("");
                    inner.add("");
                    existingExposureWithSreiList.add(inner);
                }
            }catch (SQLException sqlEx){
                System.out.println("sqlEx: " + sqlEx);
            }catch (Exception e){
                System.out.println("e: " + e);
            }
        }


        // Details of contracts in hand
        /////////////////////////////////// Query I /////////////////////////////////////////////////
        try{
            if(con==null){
                con = createConnection();
            }
            Statement stmt = con.createStatement();
            ResultSet resultData = null;
            String queryI = "select rownum srl, a.principalname, a.contractdetail natureofwork, a.originalcontractvalue, a.unexrescontractval residual, " +
                    "a.advancereceived mobilizationadv, a.contractstartdt startdate, a.contractenddt expectedenddate, a.qualityofprincipal, a.orderbook " +
                    "from CMPLX_CAM_WORKORDER a " +
                    "where a.transactionno= '" + transactionId + "'";
            WFCallBroker.generateLog("GenResp", "\nqueryI: " + queryI);
            System.out.println("queryI: "+queryI);
            resultData = stmt.executeQuery(queryI);
            WFCallBroker.generateLog("GenResp", "resultData: "+resultData);
            while (resultData.next()) {
                ArrayList<String> inner = new ArrayList<String>();
                inner.add(resultData.getString(1) != null ? resultData.getString(1) : "");
                inner.add(resultData.getString(2) != null ? resultData.getString(2) : "");
                inner.add(resultData.getString(3) != null ? resultData.getString(3) : "");
                inner.add(resultData.getString(4) != null ? resultData.getString(4) : "");
                inner.add(resultData.getString(5) != null ? resultData.getString(5) : "");
                inner.add(resultData.getString(6) != null ? resultData.getString(6) : "");
                inner.add(formatDate(resultData.getString(7) != null ? resultData.getString(7) : ""));
                inner.add(formatDate(resultData.getString(8) != null ? resultData.getString(8) : ""));
                inner.add(resultData.getString(9) != null ? resultData.getString(9) : "");
                inner.add(resultData.getString(10) != null ? resultData.getString(10) : "");
                detailsOfContractInHandList.add(inner);
            }
        }catch (SQLException sqlEx){
            System.out.println("sqlEx: " + sqlEx);
        }catch (Exception e){
            System.out.println("e: " + e);
        }

        // External Liability
        /////////////////////////////////// Query K - I /////////////////////////////////////////////////
        try{
            if(con==null){
                con = createConnection();
            }
            Statement stmt = con.createStatement();
            ResultSet resultData = null;
            String queryK = "select rownum, a.description, a.nameofbank, a.amount, a.overdue, a.installmentamount from CMPLX_CAM_EXTERNALLIABILITY a " +
                    "where a.transactionno= '" + transactionId + "'";
            WFCallBroker.generateLog("GenResp", "\nqueryK: " + queryK);
            System.out.println("queryK: " + queryK);
            resultData = stmt.executeQuery(queryK);
            WFCallBroker.generateLog("GenResp", "resultData: " + resultData);
            while (resultData.next()) {
                ArrayList<String> inner = new ArrayList<String>();
                inner.add(resultData.getString(1) != null ? resultData.getString(1) : "");
                inner.add(resultData.getString(2) != null ? resultData.getString(2) : "");
                inner.add(resultData.getString(3) != null ? resultData.getString(3) : "");
                inner.add(resultData.getString(4) != null ? resultData.getString(4) : "");
                inner.add(resultData.getString(5) != null ? resultData.getString(5) : "");
                inner.add(resultData.getString(6) != null ? resultData.getString(6) : "");
                externalLiabilityList.add(inner);
            }
        }catch (SQLException sqlEx){
            System.out.println("sqlEx: " + sqlEx);
        }catch (Exception e){
            System.out.println("e: " + e);
        }

        // External Liability Total
        /////////////////////////////////// Query K - II /////////////////////////////////////////////////
        if(externalLiabilityList.size() > 0){
            try{
                if(con==null){
                    con = createConnection();
                }
                Statement stmt = con.createStatement();
                ResultSet resultData = null;
                String queryK = "select sum(a.amount) totalamount, sum(a.overdue) totaloverdue, sum(a.installmentamount) totalinstalment from CMPLX_CAM_EXTERNALLIABILITY a " +
                        "where a.transactionno= '" + transactionId + "'";
                WFCallBroker.generateLog("GenResp", "\nqueryK: " + queryK);
                System.out.println("queryK: " + queryK);
                resultData = stmt.executeQuery(queryK);
                WFCallBroker.generateLog("GenResp", "resultData: " + resultData);
                while (resultData.next()) {
                    ArrayList<String> inner = new ArrayList<String>();
                    inner.add("");
                    inner.add("Total");
                    inner.add("");
                    inner.add(resultData.getString(1) != null ? resultData.getString(1) : "");
                    inner.add(resultData.getString(2) != null ? resultData.getString(2) : "");
                    inner.add(resultData.getString(3) != null ? resultData.getString(3) : "");
                    externalLiabilityList.add(inner);
                }
            }catch (SQLException sqlEx){
                System.out.println("sqlEx: " + sqlEx);
            }catch (Exception e){
                System.out.println("e: " + e);
            }
        }

        // Banking Details
        /////////////////////////////////// Query M - I /////////////////////////////////////////////////
        try{
            if(con==null){
                con = createConnection();
            }
            Statement stmt = con.createStatement();
            ResultSet resultData = null;
            String queryM = "select a.monthtxt, a.balanceupto15, a.balanceupto31, a.credits " +
                    "from CMPLX_CAM_BANKDETAILNEW a where a.transactionno= '" + transactionId + "'";
            WFCallBroker.generateLog("GenResp", "\nqueryM: " + queryM);
            System.out.println("queryM: " + queryM);
            resultData = stmt.executeQuery(queryM);
            WFCallBroker.generateLog("GenResp", "resultData: " + resultData);
            while (resultData.next()) {
                ArrayList<String> inner = new ArrayList<String>();
                inner.add(resultData.getString(1) != null ? resultData.getString(1) : "");
                inner.add(resultData.getString(2) != null ? resultData.getString(2) : "");
                inner.add(resultData.getString(3) != null ? resultData.getString(3) : "");
                inner.add(resultData.getString(4) != null ? resultData.getString(4) : "");
                bankingDetailsList.add(inner);
            }
        }catch (SQLException sqlEx){
            System.out.println("sqlEx: " + sqlEx);
        }catch (Exception e){
            System.out.println("e: " + e);
        }

        // Banking Details Total
        /////////////////////////////////// Query M - II /////////////////////////////////////////////////
        if(bankingDetailsList.size() > 0){
            try{
                if(con==null){
                    con = createConnection();
                }
                Statement stmt = con.createStatement();
                ResultSet resultData = null;
                String queryM = "select sum(a.credits) total, round((sum(a.credits)/sum(a.multiplier)),2) AMCI  " +
                        "from CMPLX_CAM_BANKDETAILNEW a where a.transactionno= '" + transactionId + "'";
                WFCallBroker.generateLog("GenResp", "\nqueryM: " + queryM);
                System.out.println("queryM: " + queryM);
                resultData = stmt.executeQuery(queryM);
                WFCallBroker.generateLog("GenResp", "resultData: " + resultData);
                String total = "";
                String amci = "";
                while (resultData.next()) {
                    total = resultData.getString(1) != null ? resultData.getString(1) : "";
                    amci = resultData.getString(2) != null ? resultData.getString(2) : "";
                }

                ArrayList<String> inner1 = new ArrayList<String>();
                inner1.add("Total");
                inner1.add("");
                inner1.add("");
                inner1.add(total);
                bankingDetailsList.add(inner1);

                ArrayList<String> inner2 = new ArrayList<String>();
                inner2.add("AMCI");
                inner2.add("");
                inner2.add("");
                inner2.add(amci);
                bankingDetailsList.add(inner2);

            }catch (SQLException sqlEx){
                System.out.println("sqlEx: " + sqlEx);
            }catch (Exception e){
                System.out.println("e: " + e);
            }
        }

        // Financial Highlight
        /////////////////////////////////// Query J /////////////////////////////////////////////////
        String finHighlightColumnsStr = "PERIOD,YEAR,MONTHS,BALANCESHEET,GROSSINCOME,OPERATINGPROFIT,LESSIP,LESSDEP," +
                "GROSSPROFIT,ADDOI,NETPBT,DEDCURRENTTAX,NETPAT,EQUITYCAPITAL,RESERVSURPLUS,NETWORTH,SECUREDFUND,TERMLOAN," +
                "LEASE,WORKINGCAPITAL,NONCONVERTIBLE,UNSECURELOAN,BANKFI,FROMOTHER,LOANINVESTGRPCO,SUNDRYDEBTOR,OSLESSSIX," +
                "OSABOVESIX,FIXEDASSET,cvandce,OTHERFA,INTANGIBLEASSETS,SUNDRYCREDITORS,COSTGOODSOLD,INVENTORIES," +
                "CASHGIVENOTHERS,OTHERCURRENTLIABILITES,SHORTLONGTERMDEBT,DEBTEQUITYRATIO,SECUREDLOANSTO,INCREASEINTURNOVER," +
                "EBITDAMARGIN,PATMARGIN,TERMLOANGENERATED,DEBTORDAYS,CREDITORDAYS,STOCKTURNOVERDAYS,DSCRPOSTFUNDING,ATNW," +
                "TOLORATNW,DEBTTOINCOMERATIO,CURRENTRATIO,TOTALASSETS,LONGTERMDEBTPAID,FIXEDASSETSPURCHASED,LONGTERMDEBT," +
                "SHORTTERMDEBT,AUTHORISEDCAPITAL,PAIDUPCAPITAL,GAPBETWEENITR";
        String[] finHighlightColumnsArray = finHighlightColumnsStr.split(",");
        ArrayList<ArrayList<String>> outer = new ArrayList<ArrayList<String>>();
        try{
            if(con==null){
                con = createConnection();
            }
            Statement stmt = con.createStatement();
            ResultSet resultData = null;
            String queryJ = "select " + finHighlightColumnsStr + " from cmplx_cam_finhighlights a " +
                    "where a.transactionno= '" + transactionId + "' order by 1 desc";
            WFCallBroker.generateLog("GenResp", "\nqueryJ: " + queryJ);
            System.out.println("queryJ: " + queryJ);
            resultData = stmt.executeQuery(queryJ);
            WFCallBroker.generateLog("GenResp", "resultData: " + resultData);
            while (resultData.next()) {
                ArrayList<String> inner = new ArrayList<String>();
                for(int i = 0; i < finHighlightColumnsArray.length; i++){
                    inner.add(resultData.getString(i+1) != null ? resultData.getString(i+1) : "");
                }
                outer.add(inner);
            }
            setFinancialHighlightList(outer);
        }catch (SQLException sqlEx){
            System.out.println("sqlEx: " + sqlEx);
        }catch (Exception e){
            System.out.println("e: " + e);
        }


        // clientHistoryList
        /////////////////////////////////// Query N /////////////////////////////////////////////////
        try{
            if(con==null){
                con = createConnection();
            }
            Statement stmt = con.createStatement();
            ResultSet resultData = null;
            String queryN = "select trunc(q.camapproveddate) camdate, round(a.financeamountsanc/100000,2) approvedexposure, " +
                    "(select round(sum(financeamount)/100000,2) from cmplx_cam_exposure where  transactionno=a.transactionno) existingexposure, " +
                    "(select r.approval_level from ext_los_cam r  where transactionid=a.transactionno) approval_level " +
                    "from cmplx_cam_quotesattach a, ext_los_cam q " +
                    "where a.transactionno=q.transactionid " +
                    "and q.camapproveddate>=sysdate-360 " +
                    "and a.transactionno in(select b.transactionid from ext_los_cam b where b.camstatus='CAM Approved' " +
                    "and b.partynumber=(select partynumber from ext_los_cam where transactionid='" + transactionId + "'))";
            WFCallBroker.generateLog("GenResp", "\nqueryN: " + queryN);
            System.out.println("queryN: " + queryN);
            resultData = stmt.executeQuery(queryN);
            WFCallBroker.generateLog("GenResp", "resultData: " + resultData);
            while (resultData.next()) {
                ArrayList<String> inner = new ArrayList<String>();
                inner.add(formatDate(resultData.getString(1) != null ? resultData.getString(1) : ""));
                String approvedExposure = resultData.getString(2) != null ? resultData.getString(2) : "";
                String existingExposure = resultData.getString(3) != null ? resultData.getString(3) : "";
                String totalExposure = getTotalExposure(approvedExposure, existingExposure);
                inner.add(approvedExposure);
                inner.add(existingExposure);
                inner.add(totalExposure);
                inner.add(resultData.getString(4) != null ? resultData.getString(4) : "");
                clientHistoryList.add(inner);
            }
        }catch (SQLException sqlEx){
            System.out.println("sqlEx: " + sqlEx);
        }catch (Exception e){
            System.out.println("e: " + e);
        }
        closeDbConnection();
    }

    String getTotalExposure(String approvedExposureStr, String existingExposureStr){
        DecimalFormat df2 = new DecimalFormat(".##"); // for precision only upto 2 decimal points only
        String totalExposureStr = "";
        double approvedExposure = 0.0, existingExposure = 0.0;
        try{
            approvedExposure = Double.parseDouble(approvedExposureStr);
        }catch (NumberFormatException numberFormatException){
            System.out.println("numberFormatException: " + numberFormatException);
            WFCallBroker.generateLog("GenResp", "\nnumberFormatException: " + numberFormatException);
        }

        try{
            existingExposure = Double.parseDouble(existingExposureStr);
        }catch (NumberFormatException numberFormatException){
            System.out.println("numberFormatException: " + numberFormatException);
            WFCallBroker.generateLog("GenResp", "\nnumberFormatException: " + numberFormatException);
        }

        double totalExposure = approvedExposure + existingExposure;
        totalExposureStr = df2.format(totalExposure);
        return totalExposureStr;
    }

    String getStringWithoutDecimalPart(String unformattedNumberStr){
        double formattedNumber = 0.0;
        String formattedNumberStr = "";
        try{
            formattedNumber = Double.parseDouble(unformattedNumberStr);
        } catch (NumberFormatException numberFormatException){
            System.out.println("numberFormatException: " + numberFormatException);
            WFCallBroker.generateLog("GenResp", "\nnumberFormatException: " + numberFormatException);
        }
        formattedNumberStr = String.valueOf(Double.valueOf(formattedNumber).intValue());
        return (formattedNumberStr.length() > 0 && !formattedNumberStr.equals("0")) ? formattedNumberStr : "";
    }

    void setFinancialHighlightList(ArrayList<ArrayList<String>> outer){
        if(outer == null){
            return;
        }
        String[] labelArray = {
                "Period", "Year", "Months", "Balance Sheet Type", "Gross Income", "Operating Profit(PBIDT)",
                "Less: Interest Paid", "Less: Depreciation", "Gross Income from Main Operations", "Add: Other Income",
                "Net Profit Before Tax", "Deduct: Taxes", "Net Profit After Tax", "Equity Capital", "Reserves and Surplus",
                "Tangible Net Worth", "Secured Loans", "  ~ Term Loan from Bank/FI", "  ~ Lease/HP", "  ~ Working Capital from Bank",
                "  ~ Others - Debentures", "Unsecured Loans", "  ~ Promoters and Directors", "  ~ From Others",
                "  ~ Loan/Investments within group Companies", "Sundry Debtors", "  ~ O/s less than 6 months",
                "  ~ O/s 6 months and above", "Fixed Assets", "  ~ CV and CE", "  ~ Others", "  ~ Intangible Assets",
                "  ~ Sundry Creditors", "  ~ Cost of goods sold", "  ~ Inventories", "  ~ Cash/Bank Balances, Loan and Advances " +
                "given to others and other Current assets", "  ~ Other current liabilities and provisions",
                "  ~ Short Term Portion of Long term debt", "Debt-Equity Ratio", "Secured Loan/TO(in %)", "Increase in turnover(in %)",
                "EBITDA margin(in %)", "PAT margin(in %)", "Term Loans/Cash generated", "Debtor days", "Creditor days",
                "Stock turnover days", "DSCR - Post Funding", "Adjusted tangible net worth", "TOL/ATNW", "Debt to income ratio",
                "Asset Coverage Ratio", "Total Assets", "Long-term debt paid", "Fixed assets purchased", "Long Term Debt",
                "Short term debt", "Authorised Capital", "Paidup Capital", "Gap between last 2 ITR"
        };
        for(int i = 0; i < labelArray.length; i++){
            ArrayList<String> inner = new ArrayList<String>();
            inner.add(labelArray[i]);
            inner.add(outer.size() > 0 ? outer.get(0).get(i) : "");
            inner.add(outer.size() > 1 ? outer.get(1).get(i) : "");
            inner.add(outer.size() > 2 ? outer.get(2).get(i) : "");
            inner.add(outer.size() > 3 ? outer.get(3).get(i) : "");
            financialHighlightList.add(inner);
        }
    }

    String formatDate(String unformattedDateStr){

        Date unformattedDate = null;
        try{
            unformattedDate = sdf1.parse(unformattedDateStr);
        }catch (ParseException parseException){
            System.out.println("parseException: " + parseException);
            WFCallBroker.generateLog("GenResp", "\nparseException: " + parseException);
        }

        String formattedDateStr = "";
        try{
            formattedDateStr = sdf2.format(unformattedDate);
        }catch (NullPointerException nullPointerException){
            System.out.println("nullPointerException: " + nullPointerException);
            WFCallBroker.generateLog("GenResp", "\nnullPointerException: " + nullPointerException);
        }

        return formattedDateStr;
    }

    public Connection createConnection(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("could not able to load the driver while calling getDbConnection method in "
                    + "DbConnection class");
        }
        try {
            con = DriverManager.getConnection(connectionString, cabinetName, cabinetPassword);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return con;
    }

    public void closeDbConnection() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }

    }

}
