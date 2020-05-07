package com.jzx.basic.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class AnalyzeXml {
	private static final String CHARSET = "UTF-8";

	/**
	 * string to xml
	 *
	 * @param strXml
	 *
	 * @return
	 */
	public static Document buildXmlByString(String strXml) {
		Document xmlDoc = null;
		if (strXml != null && strXml.trim().length() > 0) {
			StringReader sr = null;
			try {
				sr = new StringReader(strXml);
				InputSource is = new InputSource(sr);
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				xmlDoc = builder.parse(is);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (sr != null) {
					sr.close();
				}
			}
		}
		return xmlDoc;
	}

	/**
	 * reader to xml
	 *
	 * @param reader
	 *
	 * @return
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public static Document buildXmlByReader(Reader reader)
			throws IOException, SAXException, ParserConfigurationException {
		Document xmlDoc = null;
		try {
			InputSource is = new InputSource(reader);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			xmlDoc = builder.parse(is);
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		return xmlDoc;
	}

	/**
	 * InputStream to xml
	 *
	 * @param in
	 *
	 * @return
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public static Document buildXmlByInputStream(Reader in)
			throws IOException, SAXException, ParserConfigurationException {
		Document xmlDoc = null;
		try {
			InputSource is = new InputSource(in);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			xmlDoc = builder.parse(is);
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return xmlDoc;
	}

	public static Document BuilderxmlDoc() throws ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setIgnoringElementContentWhitespace(true);

		DocumentBuilder builder = factory.newDocumentBuilder();
		Document xmlDoc = builder.newDocument();
		// create root element
		// xmlDoc.createElement("book");
		return xmlDoc;
	}

	public static void saveXml(File file, Document doc) throws IOException, TransformerException {
		if (null == doc) {
			return;
		}
		if (!file.exists()) {
			file.createNewFile();
		}
		TransformerFactory transFactory = TransformerFactory.newInstance();
		Transformer transmer = transFactory.newTransformer();
		transmer.setOutputProperty("indent", "yes");

		DOMSource source = new DOMSource();
		source.setNode(doc);

		StreamResult result = new StreamResult();
		FileOutputStream fos = new FileOutputStream(file);
		try {
			result.setOutputStream(fos);
			transmer.transform(source, result);
		} finally {
			if (fos != null) {
				fos.close();
			}
		}
	}

	public static void print(Node node) throws TransformerException {
		if (null == node) {
			return;
		}
		TransformerFactory transFactory = TransformerFactory.newInstance();
		Transformer transformer = transFactory.newTransformer();
		transformer.setOutputProperty("encoding", CHARSET);
		transformer.setOutputProperty("indent", "yes");

		DOMSource source = new DOMSource(node);
		StreamResult result = new StreamResult();
		result.setOutputStream(System.out);

		transformer.transform(source, result);
	}

	/**
	 * search
	 *
	 * @throws XPathExpressionException
	 */
	public static Node selectSingleNode(String express, Object source) throws XPathExpressionException {
		Node result = null;
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		// 最后一个 XPathConstants.NODE 实际上没有匹配的 XPath 类型。只有知道 XPath
		// 表达式只返回一个节点或者只需要一个节点时才使用它
		result = (Node) xpath.evaluate(express, source, XPathConstants.NODE);
		return result;
	}

	public static NodeList selectNodes(String express, Object source) throws XPathExpressionException {
		NodeList result = null;
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		// 最后一个 XPathConstants.NODE 实际上没有匹配的 XPath 类型。只有知道 XPath
		// 表达式只返回一个节点或者只需要一个节点时才使用它
		// NODESET
		result = (NodeList) xpath.evaluate(express, source, XPathConstants.NODESET);
		return result;
	}

}
