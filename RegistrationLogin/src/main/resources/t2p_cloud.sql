-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: t2p_cloud
-- ------------------------------------------------------
-- Server version	5.7.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1),(1),(1),(1),(1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news` (
  `id` int(11) NOT NULL,
  `type_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `content` text COLLATE utf8_unicode_ci,
  `create_date` datetime DEFAULT NULL,
  `last_modified` datetime DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK92rftcbonyyyr1wy9ugef661w` (`type_id`),
  KEY `FK4538gbwfa03nwr9edl3fdloo9` (`user_id`),
  CONSTRAINT `FK4538gbwfa03nwr9edl3fdloo9` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK92rftcbonyyyr1wy9ugef661w` FOREIGN KEY (`type_id`) REFERENCES `types` (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (1,1,1,'<p><strong><strong><span style=\"background-color:#f39c12\">CONFERENCE AIMS &amp; OBJECTIVES</span></strong></strong></p>\r \r <p>&nbsp;</p>\r \r <p><span style=\"background-color:#8e44ad\">Systems </span><span style=\"background-color:#e74c3c\">Science and Engineering has emerged as a research field that covers a wide spectrum of modern technology. A system can be considered as a collection of entities and their interrelationships gathered together to form a whole</span> greater than the sum of the entities. It also involves people, organizations, cultures, activities and interrelationships among them. While systems composed of autonomous subsystems are not new, increased data density, connectivity and <span style=\"color:#e74c3c\">ubiquitous computational resources have increased their interdependence and interaction complexity. This </span><span style=\"color:#e74c3c\">has in turn</span><span style=\"color:#e74c3c\"> made the job of planning, developing and deploying complex systems even more difficult.</span><br />\r The International Conference on Systems Science and Engineering 2017 (ICSSE 2017) will take place in Ho Chi Minh City during July 21-23, 2017. This event will provide scholars, experts, engineers and practitioners from all over the world with a great opportunity for to present the latest system design concepts, research results, developments and applications, as well as to facilitate interactions between scholars and practitioners. ICSSE 2017 will feature plenary speeches in emerging technology topics given by world renowned scholars. The proceedings of ICSSE 2017 will be published by the IEEE with EI- indexing. In addition, selected high-quality papers will be published by special issues of SCI-indexed journals. Best paper awards will be given to those with outstanding achievements.<br />\r The conference welcomes all submission of original research papers in all aspects of system science and engineering. To broaden the scope and promote participant, organized sessions will also be welcomed and incorporated into the ICSSE 2017 program.&nbsp;<br />\r &nbsp;</p>\r \r <p><strong>TOPICS OF INTEREST INCLUDE, BUT NOT LIMITED TO:</strong></p>\r \r <table>\r 	<tbody>\r 	</tbody>\r </table>\r \r <table>\r 	<tbody>\r 		<tr>\r 			<td>\r 			<p><strong>-&nbsp;Biological systems and Evolution<br />\r 			- Communication Systems<br />\r 			- Decision Support System Modeling and Techniques&nbsp;<br />\r 			- Decision and Control Systems<br />\r 			- E-Commerce Systems<br />\r 			- Energy Saving&nbsp;<br />\r 			- Fuzzy Systems, Soft Computing and Grey Systems<br />\r 			- Human Systems&nbsp;<br />\r 			- Industrial Organization and Management<br />\r 			- Information and System Engineering&nbsp;<br />\r 			- Integrated Automation Technology Applications<br />\r 			- Intelligent Systems<br />\r 			- Medical and Health Systems&nbsp;<br />\r 			- Novel Applications of Systems Engineering<br />\r 			- Optimization&nbsp;<br />\r 			- Power systems</strong></p>\r 			</td>\r 			<td>\r 			<p><strong>- Other disciplines in System Engineering<br />\r 			- Smart Grid&nbsp;<br />\r 			- System Engineering Language&nbsp;<br />\r 			- Systems Application in Business and Industry<br />\r 			- Systems Architecting<br />\r 			- Systems Complexity&nbsp;<br />\r 			- Systems Engineering Management Process&nbsp;<br />\r 			- Systems Engineering Technical &amp; Support Process<br />\r 			- Systems Modeling, Tools and Simulation&nbsp;<br />\r 			- Systems Risk Management&nbsp;<br />\r 			- Systems Safety and Security<br />\r 			- Systems Science and Cybernetics<br />\r 			- Traffic Science and Engineering<br />\r 			- IoT in Education and Industry<br />\r 			- Renewable Energy</strong></p>\r 			</td>\r 		</tr>\r 	</tbody>\r </table>\r \r <p><br />\r <strong><span style=\"background-color:#f39c12\">IMPORTANT DEADLINES:</span></strong></p>\r \r <p>&nbsp;</p>\r \r <p>March 7, 2017</p>\r \r <p>&nbsp;</p>\r \r <p>:&nbsp;</p>\r \r <p>&nbsp;</p>\r \r <p>&nbsp; &nbsp; &nbsp;2 pages extended Abstract Submission</p>\r \r <p>March 30, 2017: &nbsp; &nbsp; &nbsp;Notification of Acceptance</p>\r \r <p>May 10, 2017</p>\r \r <p>&nbsp;</p>\r \r <p>:</p>\r \r <p>&nbsp;</p>\r \r <p>&nbsp; &nbsp; &nbsp; &nbsp;2-6 Pages Final Papers Submission</p>\r \r <p>May 30, 2017: &nbsp; &nbsp; &nbsp; &nbsp; Online Registration</p>\r \r <p><strong>&nbsp; &nbsp;</strong>&nbsp; &nbsp;&nbsp;<strong>&nbsp; &nbsp;</strong>&nbsp;</p>\r \r <p><strong><strong>SUBMISSION POLICIES:</strong></strong></p>\r \r <p><br />\r Submitted papers should be written in English. All submissions must be made electronically in PDF format via the ICSSE2017 website at&nbsp;<a href=\"http://icsse2017.hcmute.edu.vn/\" target=\"_blank\">http://icsse2017.hcmute.edu.vn</a></p>\r ','2018-03-18 00:00:00','2018-03-18 00:00:00','CONFERENCE AIMS & OBJECTIVES'),(2,2,1,'<p>All initial and final submissions to ICSSE 2017 must be written in English and typeset in the IEEE-compliant US letter-size, 2-column format. Only portable document format (PDF) files are allowed for upload.<br />\r All initial and final submissions to ICSSE 2017 must be written in English and typeset in the IEEE-compliant US letter-size, 2-column format. Only portable document format (PDF) files are allowed for upload.<br />\r <br />\r <strong>REGULAR PAPERS:</strong><br />\r <br />\r Regular Papers must be submitted electronically via the Easychair System at:</p>\r \r <p>&nbsp;<strong><a href=\"https://easychair.org/conferences/?conf=icsse2017\" target=\"_blank\">https://easychair.org/conferences/?conf=icsse2017</a></strong></p>\r \r <p><br />\r <br />\r <strong>SPECIAL-SESSION PAPERS:<br />\r <br />\r Papers must be submitted electronically via the Easychair System at:&nbsp;</strong></p>\r \r <p><strong><a href=\"https://easychair.org/conferences/?conf=icsse2017specialsess\" target=\"_blank\"><strong><strong>https://easychair.org/conferences/?conf=icsse2017specialsess</strong></strong></a></strong></p>\r \r <p><br />\r <br />\r <strong>***** SPECIAL SESSION 01</strong>:&nbsp;<strong><strong>INTELLIGENT HEALTHCARE SYSTEMS &nbsp;</strong></strong><br />\r If you want to submit a paper for Special Session 01, please add&nbsp;<strong>SS01-</strong>&nbsp;before the title of your paper when you type the title on easy chair.<br />\r Example:&nbsp;<strong><em>SS01-&nbsp;</em></strong><a name=\"1\"><strong><em>Design strategies to improve self-feeding device - FeedBot for Parkinson patients</em></strong></a></p>\r \r <p><a name=\"1\"><img alt=\"\" src=\"http://localhost:8080/Resources/Images/SubDomain/icsse2017/ss01.png\" /></a></p>\r \r <p><br />\r <strong>***** SPECIAL SESSION 02</strong>:&nbsp;FUZZY SYSTEMS AND ITS APPLICATIONS<br />\r If you want to submit a paper for Special Session 02, please add&nbsp;<strong>SS02-</strong>&nbsp;before the title of your paper when you type the title on easy chair.<br />\r Example:&nbsp;<strong><em>SS02-&nbsp;</em></strong><a name=\"1\"><strong><em>Fuzzy Restricted Boltzmann Machine for the Enhancement of Deep Learning</em></strong></a></p>\r \r <p><a name=\"1\"></a><a name=\"1\"><img alt=\"\" src=\"http://localhost:8080/Resources/Images/SubDomain/icsse2017/SS02.png\" /></a></p>\r \r <p><br />\r <br />\r &nbsp;</p>\r \r <p><a href=\"http://localhost:8080/Resources/Docs/SubDomain/icsse2017/Instruction%20easychair_ICSSE2017.docx\"><strong>CLICK HERE TO DOWNLOAD&nbsp;</strong><br />\r <strong>INSTRUCTIONS FOR&nbsp;SUBMITTING PAPER ON EASYCHAIR</strong></a></p>\r \r <p><br />\r <br />\r <strong>Initial Submission of Extended Summaries</strong><br />\r <br />\r Authors wishing to submit their work to ICSSE 2017 should initially submit an extended summary for review. Extended summaries are limited to two (2) US letter-size, double-column pages.<br />\r <br />\r The extended summary should be an overview of your presentation and covers:<br />\r 1. Backgrounds/ Research goals / Objectives;<br />\r 2. Methods;<br />\r 3. Expected results/ conclusions/ contributions;<br />\r 4. Keywords.<br />\r <br />\r Avoid using scientific or engineering symbols, acronyms and bullets. It should be typed single-spaced in 10 point type Times New Roman. Be sure to adhere to the word limit of 1000 words within 2 pages.<br />\r <br />\r <strong>Final Submission of Full Papers</strong><br />\r <br />\r All final versions of accepted papers are limited to two-four (2-4) US letter-size double-column pages at no extra charge. Authors may upload over-length papers up to a maximum of six (6) pages. However, an extra-page charge of USD 50 per page will be levied on the fifth and sixth pages.<br />\r <br />\r <strong><a name=\"size\">Page, Format and Font Settings</a></strong><br />\r <br />\r Both extended summaries and final versions must be typeset in the IEEE Xplore-compliant US letter-size, 2-column format. Prospective authors are strongly advised to download these LaTeX style files and MS Word templates which ensure that the page-size, margin and font-size requirements are satisfied. If you choose to typeset your manuscript without using the provided style files and templates, then please strictly observe the settings below:<br />\r &nbsp;</p>\r \r <table style=\"width:100%\">\r 	<tbody>\r 		<tr>\r 			<td>\r 			<table>\r 				<tbody>\r 					<tr>\r 						<td colspan=\"3\"><strong>Page Settings</strong></td>\r 					</tr>\r 					<tr>\r 						<td>&nbsp;</td>\r 						<td colspan=\"2\"><strong>Letter Paper</strong></td>\r 					</tr>\r 					<tr>\r 						<td><strong>Paper size</strong></td>\r 						<td>(8.5x11.0)in</td>\r 						<td>(21.59x27.94)cm</td>\r 					</tr>\r 					<tr>\r 						<td><strong>Top margin (1st page)</strong></td>\r 						<td>1.0in</td>\r 						<td>2.54cm</td>\r 					</tr>\r 					<tr>\r 						<td><strong>Top margin (rest)</strong></td>\r 						<td>0.75in</td>\r 						<td>1.9cm</td>\r 					</tr>\r 					<tr>\r 						<td><strong>Left margin</strong></td>\r 						<td>0.75in</td>\r 						<td>1.9cm</td>\r 					</tr>\r 					<tr>\r 						<td><strong>Right margin</strong></td>\r 						<td>0.75in</td>\r 						<td>1.9cm</td>\r 					</tr>\r 					<tr>\r 						<td><strong>Bottom margin</strong></td>\r 						<td>0.75in</td>\r 						<td>1.9cm</td>\r 					</tr>\r 					<tr>\r 						<td><strong>Text width</strong></td>\r 						<td>7.0in</td>\r 						<td>17.78cm</td>\r 					</tr>\r 					<tr>\r 						<td><strong>Text height</strong></td>\r 						<td>9.5in</td>\r 						<td>24.13cm</td>\r 					</tr>\r 					<tr>\r 						<td><strong>Column width</strong></td>\r 						<td>3.4in</td>\r 						<td>8.63cm</td>\r 					</tr>\r 					<tr>\r 						<td><strong>Column separation</strong></td>\r 						<td>0.2in</td>\r 						<td>0.5cm</td>\r 					</tr>\r 				</tbody>\r 			</table>\r 			</td>\r 			<td>&nbsp;</td>\r 			<td>\r 			<table>\r 				<tbody>\r 					<tr>\r 						<td colspan=\"2\"><strong>Font Settings</strong></td>\r 					</tr>\r 					<tr>\r 						<td><strong>Title</strong></td>\r 						<td>16pt</td>\r 					</tr>\r 					<tr>\r 						<td><strong>Author list</strong></td>\r 						<td>11pt</td>\r 					</tr>\r 					<tr>\r 						<td><strong>Section titles</strong></td>\r 						<td>10pt</td>\r 					</tr>\r 					<tr>\r 						<td><strong>Normal text</strong></td>\r 						<td>10pt</td>\r 					</tr>\r 					<tr>\r 						<td><strong>Table/Figure captions</strong></td>\r 						<td>10pt</td>\r 					</tr>\r 					<tr>\r 						<td><strong>Sub-scripts</strong></td>\r 						<td>8pt</td>\r 					</tr>\r 					<tr>\r 						<td><strong>Sub-sub-scripts</strong></td>\r 						<td>7pt</td>\r 					</tr>\r 					<tr>\r 						<td><strong>Footnotes</strong></td>\r 						<td>8pt</td>\r 					</tr>\r 				</tbody>\r 			</table>\r 			</td>\r 		</tr>\r 	</tbody>\r </table>\r \r <p>.</p>\r \r <table border=\"0\" style=\"width:98%\">\r 	<tbody>\r 		<tr>\r 			<th><a name=\"latex\">LaTeX Support</a></th>\r 		</tr>\r 		<tr>\r 			<td>1.&nbsp;Authors who intend to typeset their manuscripts using LaTeX should download the following style and instruction files:<br />\r 			- The zipped file&nbsp;<a href=\"http://controls.papercept.net/conferences/support/files/ieeeconf.zip\" target=\"_blank\">ieeeconf.zip</a>&nbsp;which contains the LaTeX class file ieeeconf.cls, a sample LaTeX source file root.tex and its compiled document root.pdf.<br />\r 			- The zipped file&nbsp;<a href=\"http://controls.papercept.net/conferences/support/files/IEEEtranBST.zip\" target=\"_blank\">IEEEtranBST.zip</a>&nbsp;which contains BiBTeX styles and examples.<br />\r 			- A guide to using ieeeconf.cls&nbsp;<a href=\"http://controls.papercept.net/conferences/support/files/IEEEtranBST.zip\" target=\"_blank\">IEEEtran_HOWTO.pdf</a>.<br />\r 			<br />\r 			2. The latest versions of&nbsp;<a href=\"http://www.miktex.org/\" target=\"_blank\">MikTeX</a>&nbsp;(2.9 for Windows) or&nbsp;<a href=\"http://www.tug.org/texlive\" target=\"_blank\">TeX Live</a>&nbsp;(2015 for Windows, Linux,&nbsp;<a href=\"http://www.cygwin.com/\" target=\"_blank\">Cygwin</a>) are strongly recommended tools for typesetting using the supplied styles.<br />\r 			3. To produce compliant PDFs,&nbsp;<a href=\"http://www.ghostscript.com/\" target=\"_blank\">Ghostscript</a>&nbsp;9.15 or higher is recommended. Linux or Cygwin users may also use this&nbsp;<a href=\"http://www.twtasse.org/icsse2016/data/dvipdfltr\" target=\"_blank\">shell script</a>&nbsp;to produce compliant PDFs.<br />\r 			4. Do not encrypt nor password-protect your PDF.</td>\r 		</tr>\r 		<tr>\r 			<td>&nbsp;</td>\r 		</tr>\r 		<tr>\r 			<th><a name=\"msword\">MS Word Support</a></th>\r 		</tr>\r 		<tr>\r 			<td>1. Authors who intend to typeset their manuscripts using Microsoft Word should download the following template:<br />\r 			- MS Word template&nbsp;<a href=\"http://localhost:8080/Resources/Docs/SubDomain/icsse2017/ieeeconf_letter.doc\" target=\"_blank\">ieeeconf_letter.doc</a>&nbsp;for US Letter paper<br />\r 			<br />\r 			2. Microsoft Word 2010 or later is strongly recommended for typesetting in IEEE Xplore-compliant format.<br />\r 			3. To produce compliant PDFs, use the &quot;Save as PDF&quot; feature which is built into MS Office 2010. Make sure that the following options are selected:<br />\r 			-&nbsp;Optimize for: Standard (publishing online and printing)<br />\r 			- Options &gt; PDF options &gt; Bitmap text when fonts may not be embedded<br />\r 			<br />\r 			4. Do not encrypt nor password-protect your PDF.</td>\r 		</tr>\r 	</tbody>\r </table>\r ','2018-03-18 00:00:00','2018-03-18 00:00:00','REGULAR PAPERS:'),(3,3,1,'<p><a href=\"http://localhost:8080/indexeacd.html?TopicId=a00b00cc-8531-426e-b305-00ced720720e\">REGISTRATION</a></p>\r \r <p><strong>REGISTRATION FEES</strong><br />\r &nbsp;</p>\r \r <table border=\"0\" cellpadding=\"0\" style=\"width:102%\">\r 	<tbody>\r 		<tr>\r 			<td>\r 			<p><strong>CATEGORY</strong></p>\r 			</td>\r 			<td>\r 			<p><strong>REQUIRED</strong></p>\r 			</td>\r 			<td>\r 			<p><strong>EARLY BIRD RATE&nbsp;<br />\r 			(BEFORE May 15)</strong></p>\r 			</td>\r 			<td>\r 			<p><strong>STANDARD RATE<br />\r 			(AFTER May 15)</strong></p>\r 			</td>\r 		</tr>\r 		<tr>\r 			<td>\r 			<p>Regular registration</p>\r 			</td>\r 			<td>\r 			<p>&nbsp;</p>\r 			</td>\r 			<td>\r 			<p>VND 8,800,000</p>\r \r 			<p>(USD 400)</p>\r 			</td>\r 			<td>\r 			<p>VND 10,300,000</p>\r \r 			<p>&nbsp;(USD 470)</p>\r 			</td>\r 		</tr>\r 		<tr>\r 			<td>\r 			<p>Student registration<br />\r 			(Excludes Welcome dinner, Banquet and Tour)</p>\r 			</td>\r 			<td>\r 			<p>&nbsp;</p>\r 			</td>\r 			<td>\r 			<p>VND 4,400,000</p>\r \r 			<p>(USD 200)</p>\r 			</td>\r 			<td>\r 			<p>VND 5,500,000</p>\r \r 			<p>(USD 250)</p>\r 			</td>\r 		</tr>\r 		<tr>\r 			<td>\r 			<p>Over-length page charge<br />\r 			(Max. 2 pages/paper)</p>\r 			</td>\r 			<td>\r 			<p>Each additional page</p>\r 			</td>\r 			<td>\r 			<p>VND 2,200,000</p>\r \r 			<p>(USD 100)</p>\r 			</td>\r 			<td>\r 			<p>VND 2,200,000</p>\r \r 			<p>(USD 100)</p>\r 			</td>\r 		</tr>\r 		<tr>\r 			<td>\r 			<p>Additional publication fee<br />\r 			(Limited to 1 extra paper/registration)</p>\r 			</td>\r 			<td>\r 			<p>Each additional paper</p>\r 			</td>\r 			<td>\r 			<p>VND 5,500,000</p>\r \r 			<p>(USD 250)</p>\r 			</td>\r 			<td>\r 			<p>VND 5,500,000</p>\r \r 			<p>(USD 250)</p>\r 			</td>\r 		</tr>\r 		<tr>\r 			<td>\r 			<p>Additional banquet ticket</p>\r 			</td>\r 			<td>\r 			<p>Each additional ticket</p>\r 			</td>\r 			<td>\r 			<p>VND 1,650,000</p>\r \r 			<p>(USD 75)</p>\r 			</td>\r 			<td>\r 			<p>VND 1,650,000</p>\r \r 			<p>(USD 75)</p>\r 			</td>\r 		</tr>\r 		<tr>\r 			<td>\r 			<p>Additional welcome dinner ticket</p>\r 			</td>\r 			<td>\r 			<p>Each additional ticket</p>\r 			</td>\r 			<td>\r 			<p>VND 900,000</p>\r \r 			<p>(USD 45)</p>\r 			</td>\r 			<td>\r 			<p>VND 900,000</p>\r \r 			<p>(USD 45)</p>\r 			</td>\r 		</tr>\r 	</tbody>\r </table>\r \r <p>&nbsp;<br />\r <strong>&nbsp;REGISTRATION POLICIES</strong><br />\r &nbsp;</p>\r \r <p>1. For each paper, at least one author must pay a Regular Registration fee by May 15 accompanied with the paper Submission Number. Each Regular Registration allows final submission of one paper, plus an additional paper for an Additional Publication Fee of VND 5,500,000 (USD 250).<br />\r &nbsp;</p>\r \r <p>2. An uploaded final manuscript will be included in the conference technical program only after full payment of the Regular Registration fee, or an Additional Publication Fee if applicable. Upload of an over-length paper is allowed only after payment of the applicable extra-page charge.<br />\r &nbsp;</p>\r \r <p>3. All final versions of accepted papers are limited to two-four (2-4) US letter-size double-column pages at no extra charge. Authors may upload over-length papers up to a maximum of six (6) pages. However, an extra-page charge of VND 2,200,000 (USD 100) per page will be levied on the fifth and sixth pages.<br />\r &nbsp;</p>\r \r <p>4. Each Regular Registration includes 1 special gift, 1 welcome dinner, 1 banquet ticket, 1 conference digest, 1 CD-ROM (or USB drive) proceedings, and access to all sessions, lunches, coffee breaks.<br />\r &nbsp;</p>\r \r <p>5. Each student registration includes all of the items in regular registration except welcome dinner and banquet.<br />\r &nbsp;</p>\r \r <p>6. Student Registration: To qualify for the student rate, a proof of current full-time student status (i.e., a copy of student card or certification from university) will be required.</p>\r ','2018-03-18 00:00:00','2018-03-18 00:00:00','PAYMENT INSTRUCTIONS'),(4,4,1,'Abstract:\nCollection and analysis of data from deployed networks is essential for understanding modern communication networks. Data mining and statistical analysis of network data are often employed to determine traffic loads, analyze patterns of users\' behavior, and predict future network traffic while various machine learning techniques proved valuable for predicting anomalous traffic behavior. In described case studies, traffic traces collected from various deployed networks and the Internet are used to characterize and model network traffic, analyze Internet topologies, and classify network anomalies.\n','2018-03-18 00:00:00','2018-03-18 00:00:00','***** KEYNOTE SPEAKERS *****'),(5,5,1,'Ho Chi Minh City University of Technology and Education\nNo. 01 Vo Van Ngan Street, Thu Duc District, Ho Chi Minh City\n','2018-03-18 00:00:00','2018-03-18 00:00:00','CONFERENCE VENUE:'),(6,6,1,'<p>System Science and Engineering has emerged as a research field that covers a wide spectrum of modern technology. A system can be considered as a collection of entities and their interrelationships gathered together to form a whole greater than the sum of the entities. It also involves people, organizations, cultures, activities and interrelationships among them. While systems composed of autonomous subsystems are not new, increased data density, connectivity and ubiquitous computational resources have increased their interdependence and interaction complexity. This has in turn made the already difficult job of planning, developing and deploying complex systems even more difficult.</p>\n\n<p>Technology advancement not only provides opportunities for improving system capabilities but also introduces development risks that must be weighed and managed. Thus, it is our goal to bring together scholars from all areas to have a forum to discuss, demonstrate and exchange research ideas in the scope of system science and engineering.<p/>\n\n<p>The International Conference on System Science and Engineering 2017 (ICSSE 2017) is an international conference that will take place in Ho Chi Minh City during July 21-23, 2017. This event will provide a great opportunity for scientists, engineers, and practitioners from all over the world to present the latest system design concepts, research results, developments and applications, as well as to facilitate interactions between scholars and practitioners. ICSSE 2017 will feature plenary speeches in emerging technology topics given by world renowned scholars. The proceedings of ICSSE 2017 will be published by the IEEE with EI indexing. In addition, selected high-quality papers will be published by special issues of SCI-indexed journals. <p/>\n','2018-03-18 00:00:00','2018-03-18 00:00:00','WELCOME TO ICSSE 2017\n'),(7,7,1,'CONFERENCE \nEmail: icsse2017@hcmute.edu.vn\nLocation: HCMC University of Technology and Education\n01 Vo Van Ngan Street, Linh Chieu Ward, Thu Duc District, Ho Chi Minh City \n\nVIETNAM\n1. A/P. Hoang An Quoc - Email: hanquoc@hcmute.edu.vn\n2. A/P. Do Thanh Trung - Email: trungdt@hcmute.edu.vn\n\nTAIWAN\nProf. Yo-Ping Huang - Email: yphuang@ntut.edu.tw','2018-03-18 00:00:00','2018-03-18 00:00:00','CONTACT INFORMATION'),(8,8,1,'Dear all authors,\n\nCongratulations! 2017 International Conference on System Science and Engineering (ICSSE) has been posted to the IEEE Xplore digital library effective 2017-09-11. \n\nThe publication link is shown below:\nhttp://ieeexplore.ieee.org/xpl/mostRecentIssue.jsp?punumber=8024255\n\nThanks once again for everything that you had contributed at the conference.\n\nBest regards to you.','2018-03-18 00:00:00','2018-03-18 00:00:00','Congratulations! 2017 International Conference on System Science and Engineering (ICSSE) is now published in IEEE Xplore'),(9,9,1,'PROGRAM OUTLINE\n \nIMPORTANT INFORMATION FOR ALL PARTICIPANTS\n\nPlease wear your ICSSE 2017 Conference name tag at all times to gain admission to presentation in break-out rooms.\n\nName tags and tickets are required for Conference Gala Banquet.\n\nIf you need any formation about the conference, please ask the student helpers or committee members for assistance.','2018-03-18 00:00:00','2018-03-18 00:00:00','OFFICIAL PROGRAM OF ICSSE 2017'),(10,10,1,'Dear author,\n\nConference committee are glad to inform that total pages of full paper is around from four to six (4-6) pages length instead of 2-4 pages as previous annoucement. That means all final versions of accepted papers are limited from four to six US letter-size double-column pages without extra charge. \n\nAuthors may upload over-length papers up to a maximum of eight (8) pages. However, an extra-page has to charge VND 2,270,000 (USD 100) per page.\n\nThank you very much!','2018-03-18 00:00:00','2018-03-18 00:00:00','LENGTH OF FULL PAPER IS AROUND FROM 4 TO 6 PAGES'),(11,11,1,'<div id=\"ctl06_portlet_b633be64-8363-4e53-9952-6acf34d3e9e9\" style=\"float:left\">\r <div class=\"thongbao_phong\">\r <div class=\"topictb_phong_blue\">\r <h3>Latest news</h3>\r <a class=\"wobble-horizontal\" href=\"indexc059.html?TopicId=31ca0f13-71be-4bd9-ad28-d3589a3cf6d2\"><img src=\"/resources/Resources/ImagesPortal/PhongBan/arrow_all_phong.png\" /> </a></div>\r \r <div class=\"listtb_phong\">\r <ul>\r 	<li>&nbsp;\r 	<p><a href=\"&lt;c:url value=\">Create Date 09/03/2017</a></p>\r 	<a href=\"&lt;c:url value=\">&quot;SPECIAL SESSION 02 FOR ICSSE2017: FUZZY SYSTEMS AND ITS APPLICATIONS </a></li>\r 	<li>&nbsp;\r 	<p><a href=\"&lt;c:url value=\"><span style=\"background-color:#2ecc71\">Create Date 07/03/2017</span></a></p>\r 	<a href=\"&lt;c:url value=\"><span style=\"background-color:#e74c3c\">ABSTRACT DEADLINE EXTENSION: MARCH 19, 2017 </span></a></li>\r 	<li>&nbsp;\r 	<p><a href=\"&lt;c:url value=\">Create Date 20/02/2017</a></p>\r 	<a href=\"&lt;c:url value=\"><span style=\"color:#e74c3c\">SPECIAL SESSION 01 FOR ICSSE2017: INTELLIGENT HEALTHCARE SYSTEMS </span></a></li>\r </ul>\r </div>\r </div>\r </div>\r \r <div id=\"ctl06_portlet_b633be64-8363-4e53-9952-6acf34d3e9e9\" style=\"float:left\">\r <div class=\"thongbao_phong\"><span style=\"color:#e74c3c\"><!--end listtb_phong--></span></div>\r </div>\r \r <div id=\"ctl06_portlet_9d945843-6c22-4daf-9b88-835da3891673\" style=\"float:left\">\r <div>\r <div style=\"text-align:center\">&nbsp;</div>\r \r <div style=\"text-align:center\"><span style=\"color:#e74c3c\"><span style=\"font-size:16px\"><span style=\"font-size:16px\">2-6 Pages Final Papers Submission</span> </span></span></div>\r \r <div style=\"text-align:center\"><span style=\"color:#e74c3c\"><span style=\"font-size:16px\"><strong>May 10, 2017</strong> </span></span></div>\r \r <div style=\"text-align:center\">&nbsp;</div>\r \r <div style=\"text-align:center\"><span style=\"color:#e74c3c\"><span style=\"font-size:16px\"><span style=\"font-size:16px\">Notification of Acceptance</span> </span></span></div>\r \r <div style=\"text-align:center\"><span style=\"color:#e74c3c\"><span style=\"font-size:16px\"><strong>March 30, 2017</strong> </span></span></div>\r \r <div style=\"text-align:center\">&nbsp;</div>\r \r <div style=\"text-align:center\"><span style=\"color:#e74c3c\"><span style=\"font-size:16px\"><span style=\"font-size:16px\">2-Pages &nbsp;Extended Abstract&nbsp;</span><span style=\"font-size:16px\">Submission</span></span></span></div>\r \r <div style=\"text-align:center\"><strong><strong><span style=\"font-size:16px\"><s>March 7, 2017</s><br />\r <strong>Extended untill March 19, 2017</strong></span></strong></strong></div>\r \r <p style=\"text-align:justify\">&nbsp;</p>\r \r <table>\r 	<tbody>\r 		<tr>\r 			<td style=\"background-color:#ff0000; height:40px; text-align:left; vertical-align:middle; width:350px\"><span style=\"color:#e74c3c\">&nbsp;<span style=\"font-size:20px\"><strong><span style=\"background-color:#1abc9c\">IMPORTANT DEADLINES </span></strong></span></span></td>\r 		</tr>\r 	</tbody>\r </table>\r \r <p>&nbsp;</p>\r </div>\r </div>\r \r <div id=\"ctl06_portlet_9d945843-6c22-4daf-9b88-835da3891673\" style=\"float:left\">\r <div>\r <div style=\"text-align:center\">&nbsp;</div>\r \r <div style=\"text-align:center\"><span style=\"font-size:16px\"><span style=\"font-size:14px\"><span style=\"color:#002060; font-size:16px\"><strong>May 30, 2017</strong><span style=\"font-size:16px\">:&nbsp;</span></span> </span></span></div>\r \r <div style=\"text-align:center\"><span style=\"font-size:16px\"><span style=\"font-size:14px\"><span style=\"color:#002060; font-size:16px\"><span style=\"font-size:16px\">Online Registration</span> </span></span></span></div>\r </div>\r </div>\r \r <div id=\"ctl06_portlet_553574d9-9245-4da8-a214-baf51898689a\" style=\"float:left\">\r <div>\r <table>\r 	<tbody>\r 		<tr>\r 			<td style=\"background-color:#92d050; height:40px; width:350px\"><strong><span style=\"color:#c00000; font-size:20px\">SPECIAL SESSION</span></strong></td>\r 		</tr>\r 	</tbody>\r </table>\r <br />\r <span style=\"font-family:&amp; quot; font-size:10.5pt\"><strong><strong><a href=\"https://easychair.org/conferences/?conf=icsse2017specialsess\" target=\"_blank\">SPECIAL SESSION SUBMISSION LINK</a>&nbsp;</strong></strong></span><br />\r &nbsp;\r <div style=\"text-align:center\"><span style=\"font-family:&amp; quot; font-size:10.5pt\"><span style=\"font-size:14px\"><strong><span style=\"color:#002060\"><strong><strong>SPECIAL SESSION&nbsp;</strong></strong>01</span></strong> </span></span></div>\r <span style=\"font-family:&amp; quot; font-size:10.5pt\"><span style=\"font-size:14px\"> <strong> </strong></span></span>\r \r <div style=\"text-align:center\"><span style=\"font-family:&amp; quot; font-size:10.5pt\"><span style=\"font-size:14px\"><strong><strong><span style=\"background-color:#ffff00; color:#002060\">INTELLIGENT HEALTHCARE SYSTEMS</span></strong> </strong></span></span></div>\r <span style=\"font-family:&amp; quot; font-size:10.5pt\"><span style=\"font-size:14px\"><strong> </strong></span> </span>\r \r <div style=\"color:#002060; font-weight:bold; text-align:center\"><span style=\"font-family:&amp; quot; font-size:10.5pt\"><span style=\"font-size:10.5pt\"><a href=\"Resources/Docs/SubDomain/icsse2017/SS_cfp_Huang.pdf\">CALL FOR PAPERS</a></span> </span></div>\r <span style=\"font-family:&amp; quot; font-size:10.5pt\"> </span>\r \r <div style=\"text-align:center\"><span style=\"font-family:&amp; quot; font-size:10.5pt\"><strong><span style=\"font-size:20px\"><strong><span style=\"background-color:#ffff00; color:#002060; font-size:14px\"><strong><span style=\"color:#002060\"><strong><strong>SPECIAL SESSION&nbsp;</strong></strong></span></strong>02<br />\r FUZZY SYSTEMS &amp; ITS APPLICATIONS</span></strong></span></strong> </span></div>\r <span style=\"font-family:&amp; quot; font-size:10.5pt\"> <strong> </strong></span>\r \r <div style=\"text-align:center\"><span style=\"font-family:&amp; quot; font-size:10.5pt\"><strong><strong><a href=\"Resources/Docs/SubDomain/icsse2017/SS02%20-%20call4pp.pdf\" style=\"margin: 0px; padding: 0px; text-decoration: none;\">CALL FOR PAPER</a></strong> </strong></span></div>\r <span style=\"font-family:&amp; quot; font-size:10.5pt\"><strong> </strong> </span></div>\r </div>\r \r <div id=\"ctl06_portlet_78439b67-a318-4ced-ac29-33d02da2a0fb\" style=\"float:left\">\r <div>\r <table>\r 	<tbody>\r 		<tr>\r 			<td style=\"background-color:#002060; height:40px; text-align:left; vertical-align:middle; width:350px\">&nbsp;<span style=\"color:#ffff00; font-size:20px\"><strong>KEY LINKS</strong></span></td>\r 		</tr>\r 	</tbody>\r </table>\r <br />\r <span style=\"color:#002060\"><span style=\"font-size:14px\"><a href=\"https://easychair.org/conferences/?conf=icsse2017\" target=\"_blank\"><strong>EASYCHAIR SUBMISSION SITE</strong></a></span><br />\r <br />\r <span style=\"font-size:14px\"><a href=\"Resources/Docs/SubDomain/icsse2017/ieeeconf_letter.doc\"><strong>PAPER FORMAT TEMPLATE DOWNLOAD</strong></a>&nbsp;</span></span><br />\r <br />\r <span style=\"font-size:14px\"><strong><a href=\"Resources/Docs/SubDomain/icsse2017/Instruction%20easychair_ICSSE2017.docx\"><strong>EASYCHAIR&nbsp;</strong>SUBMISSION INSTRUCTION</a></strong></span></div>\r </div>\r ','2018-03-18 00:00:00','2018-03-18 00:00:00',' KEY LINKS');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `password_reset_token`
--

DROP TABLE IF EXISTS `password_reset_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `password_reset_token` (
  `id` bigint(20) NOT NULL,
  `expiry_date` datetime DEFAULT NULL,
  `token` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5lwtbncug84d4ero33v3cfxvl` (`user_id`),
  CONSTRAINT `FK5lwtbncug84d4ero33v3cfxvl` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `password_reset_token`
--

LOCK TABLES `password_reset_token` WRITE;
/*!40000 ALTER TABLE `password_reset_token` DISABLE KEYS */;
/*!40000 ALTER TABLE `password_reset_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `privilege`
--

DROP TABLE IF EXISTS `privilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `privilege` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privilege`
--

LOCK TABLES `privilege` WRITE;
/*!40000 ALTER TABLE `privilege` DISABLE KEYS */;
/*!40000 ALTER TABLE `privilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin'),(2,'user');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles_privileges`
--

DROP TABLE IF EXISTS `roles_privileges`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles_privileges` (
  `role_id` bigint(20) NOT NULL,
  `privilege_id` bigint(20) NOT NULL,
  KEY `FK5yjwxw2gvfyu76j3rgqwo685u` (`privilege_id`),
  KEY `FK9h2vewsqh8luhfq71xokh4who` (`role_id`),
  CONSTRAINT `FK5yjwxw2gvfyu76j3rgqwo685u` FOREIGN KEY (`privilege_id`) REFERENCES `privilege` (`id`),
  CONSTRAINT `FK9h2vewsqh8luhfq71xokh4who` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles_privileges`
--

LOCK TABLES `roles_privileges` WRITE;
/*!40000 ALTER TABLE `roles_privileges` DISABLE KEYS */;
/*!40000 ALTER TABLE `roles_privileges` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `types`
--

DROP TABLE IF EXISTS `types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `types` (
  `type_id` int(11) NOT NULL,
  `type_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `types`
--

LOCK TABLES `types` WRITE;
/*!40000 ALTER TABLE `types` DISABLE KEYS */;
INSERT INTO `types` VALUES (1,'call paper'),(2,'submission'),(3,'registration'),(4,'keynote speaker'),(5,'hotel'),(6,'home'),(7,'contact'),(8,'latest new first'),(9,'latest new second'),(10,'latest new third'),(11,'sidebar');
/*!40000 ALTER TABLE `types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `first_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin@gmail.com','','thang','pham','123456');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  KEY `FKt4v0rrweyk393bdgt107vdx0x` (`role_id`),
  KEY `FKgd3iendaoyh04b95ykqise6qh` (`user_id`),
  CONSTRAINT `FKgd3iendaoyh04b95ykqise6qh` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKt4v0rrweyk393bdgt107vdx0x` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (1,1);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `verification_token`
--

DROP TABLE IF EXISTS `verification_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `verification_token` (
  `id` bigint(20) NOT NULL,
  `expiry_date` datetime DEFAULT NULL,
  `token` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrdn0mss276m9jdobfhhn2qogw` (`user_id`),
  CONSTRAINT `FKrdn0mss276m9jdobfhhn2qogw` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `verification_token`
--

LOCK TABLES `verification_token` WRITE;
/*!40000 ALTER TABLE `verification_token` DISABLE KEYS */;
/*!40000 ALTER TABLE `verification_token` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-18 11:40:42
