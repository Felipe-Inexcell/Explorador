package cl.inexcell.sistemadegestion;

public class URLs {

    public static String PARAELECTRI = "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:tns=\"urn:Demo\">" +
               "<SOAP-ENV:Body>" +
                  "<ns1:ParaElectriResponse xmlns:ns1=\"urn:Demo\">" +
                     "<ResponseParaElectri xsi:type=\"tns:ResponseParaElectri\">" +
                        "<Operation xsi:type=\"tns:OperationType\">" +
                           "<OperationCode xsi:type=\"xsd:string\">?</OperationCode>" +
                           "<OperationId xsi:type=\"xsd:string\">?</OperationId>" +
                           "<DateTime xsi:type=\"xsd:string\">?</DateTime>" +
                           "<IdUser xsi:type=\"xsd:string\">?</IdUser>" +
                           "<IMEI xsi:type=\"xsd:string\">?</IMEI>" +
                           "<IMSI xsi:type=\"xsd:string\">?</IMSI>" +
                        "</Operation>" +
                        "<Service xsi:type=\"tns:ServiceParaElectriOut\">" +
                           "<ParaElectri xsi:type=\"tns:ParaElectriOut\">" +
                              "<Output xsi:type=\"tns:ParaElectriOutData\">" +
                                 "<Element xsi:type=\"tns:ElementTypeParaElectri\">" +
                                    "<Identification xsi:type=\"tns:IdentificationTypeDCT\">" +
                                       "<ParametersCajas xsi:type=\"tns:ParametersTypeDCTCajas\">" +
                                          "<id xsi:type=\"xsd:string\">0</id>" +
                                          "<Proveedor xsi:type=\"xsd:string\">HUAWEI</Proveedor>" +
                                          "<dslam xsi:type=\"xsd:string\">MA5600_WASHINGTON-55_F1</dslam>" +
                                          "<Velocidad xsi:type=\"xsd:string\">7080</Velocidad>" +
                                       "</ParametersCajas>" +
                                       "<ParametersCajas xsi:type=\"tns:ParametersTypeDCTCajas\">" +
                                          "<id xsi:type=\"xsd:string\">1</id>" +
                                          "<Proveedor xsi:type=\"xsd:string\">ALCATEL</Proveedor>" +
                                          "<dslam xsi:type=\"xsd:string\">WASHINGTON-32-SR1</dslam>" +
                                          "<Velocidad xsi:type=\"xsd:string\">6144</Velocidad>" +
                                       "</ParametersCajas>" +
                                       "<ParametersCajas xsi:type=\"tns:ParametersTypeDCTCajas\">" +
                                          "<id xsi:type=\"xsd:string\">1</id>" +
                                          "<Proveedor xsi:type=\"xsd:string\">ALCATEL</Proveedor>" +
                                          "<dslam xsi:type=\"xsd:string\">WASHINGTON-4</dslam>" +
                                          "<Velocidad xsi:type=\"xsd:string\">0</Velocidad>" +
                                       "</ParametersCajas>" +
                                       "<ParametersFonos xsi:type=\"tns:ParametersTypeDCTFonos\">" +
                                          "<Par xsi:type=\"xsd:string\">21</Par>" +
                                          "<Area xsi:type=\"xsd:string\">1</Area>" +
                                          "<Fono xsi:type=\"xsd:string\">3326148</Fono>" +
                                          "<Tipo xsi:type=\"xsd:string\">Banda Ancha</Tipo>" +
                                          "<Perfil xsi:type=\"xsd:string\">HUAWEI_4000_512_16_8_D80</Perfil>" +
                                          "<ParametersFonosCabecera xsi:type=\"tns:ParametersTypeDCTFonosCabecera\">" +
                                             "<Vendor xsi:type=\"xsd:string\">HUAWEI</Vendor>" +
                                             "<DSLAM xsi:type=\"xsd:string\">MA5600_WASHINGTON-55_F1</DSLAM>" +
                                             "<Model xsi:type=\"xsd:string\">MA5600</Model>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Vel. Act. Upstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\">511</Value>" +
                                             "</ParametersElectricos>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Vel. Max.Upstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\">1078</Value>" +
                                             "</ParametersElectricos>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Ruido Upstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\">26.5</Value>" +
                                             "</ParametersElectricos>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Atenuacion Upstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\">27.7</Value>" +
                                             "</ParametersElectricos>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Ocupacion Upstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\">47</Value>" +
                                             "</ParametersElectricos>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Vel. Act. Downstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\">3200</Value>" +
                                             "</ParametersElectricos>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Vel. Max. Downstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\">7080</Value>" +
                                             "</ParametersElectricos>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Ruido Downstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\">13.5</Value>" +
                                             "</ParametersElectricos>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Atenuacion Downstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\">47.7</Value>" +
                                             "</ParametersElectricos>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Ocupacion  Downstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\">45</Value>" +
                                             "</ParametersElectricos>" +
                                          "</ParametersFonosCabecera>" +
                                       "</ParametersFonos>" +
                                       "<ParametersFonos xsi:type=\"tns:ParametersTypeDCTFonos\">" +
                                          "<Par xsi:type=\"xsd:string\">23</Par>" +
                                          "<Area xsi:type=\"xsd:string\">1</Area>" +
                                          "<Fono xsi:type=\"xsd:string\">3326026</Fono>" +
                                          "<Tipo xsi:type=\"xsd:string\">Banda Ancha</Tipo>" +
                                          "<Perfil xsi:type=\"xsd:string\">ISAM_2000_256_16_8_2_1</Perfil>" +
                                          "<ParametersFonosCabecera xsi:type=\"tns:ParametersTypeDCTFonosCabecera\">" +
                                             "<Vendor xsi:type=\"xsd:string\">ALCATEL</Vendor>" +
                                             "<DSLAM xsi:type=\"xsd:string\">WASHINGTON-32-SR1</DSLAM>" +
                                             "<Model xsi:type=\"xsd:string\">ISAM 7300</Model>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Vel. Act. Upstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\">256</Value>" +
                                             "</ParametersElectricos>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Vel. Max.Upstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\">952</Value>" +
                                             "</ParametersElectricos>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Ruido Upstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\">32.1</Value>" +
                                             "</ParametersElectricos>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Atenuacion Upstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\">27.7</Value>" +
                                             "</ParametersElectricos>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Ocupacion Upstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\">34</Value>" +
                                             "</ParametersElectricos>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Vel. Act. Downstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\">1984</Value>" +
                                             "</ParametersElectricos>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Vel. Max. Downstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\">6144</Value>" +
                                             "</ParametersElectricos>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Ruido Downstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\">23</Value>" +
                                             "</ParametersElectricos>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Atenuacion Downstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\">41.5</Value>" +
                                             "</ParametersElectricos>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Ocupacion  Downstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\">37</Value>" +
                                             "</ParametersElectricos>" +
                                          "</ParametersFonosCabecera>" +
                                       "</ParametersFonos>" +
                                       "<ParametersFonos xsi:type=\"tns:ParametersTypeDCTFonos\">" +
                                          "<Par xsi:type=\"xsd:string\">24</Par>" +
                                          "<Area xsi:type=\"xsd:string\">1</Area>" +
                                          "<Fono xsi:type=\"xsd:string\">4243466</Fono>" +
                                          "<Tipo xsi:type=\"xsd:string\">Telefonía</Tipo>" +
                                          "<Perfil xsi:type=\"xsd:string\"/>" +
                                          "<ParametersFonosCabecera xsi:type=\"tns:ParametersTypeDCTFonosCabecera\">" +
                                             "<Vendor xsi:type=\"xsd:string\"/>" +
                                             "<DSLAM xsi:type=\"xsd:string\"/>" +
                                             "<Model xsi:type=\"xsd:string\"/>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Vel. Act. Upstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\"/>" +
                                             "</ParametersElectricos>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Vel. Max.Upstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\"/>" +
                                             "</ParametersElectricos>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Ruido Upstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\"/>" +
                                             "</ParametersElectricos>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Atenuacion Upstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\"/>" +
                                             "</ParametersElectricos>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Ocupacion Upstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\"/>" +
                                             "</ParametersElectricos>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Vel. Act. Downstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\"/>" +
                                             "</ParametersElectricos>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Vel. Max. Downstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\"/>" +
                                             "</ParametersElectricos>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Ruido Downstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\"/>" +
                                             "</ParametersElectricos>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Atenuacion Downstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\"/>" +
                                             "</ParametersElectricos>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Ocupacion  Downstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\"/>" +
                                             "</ParametersElectricos>" +
                                          "</ParametersFonosCabecera>" +
                                       "</ParametersFonos>" +
                                       "<ParametersFonos xsi:type=\"tns:ParametersTypeDCTFonos\">" +
                                          "<Par xsi:type=\"xsd:string\">22</Par>" +
                                          "<Area xsi:type=\"xsd:string\">1</Area>" +
                                          "<Fono xsi:type=\"xsd:string\">4335539</Fono>" +
                                          "<Tipo xsi:type=\"xsd:string\">Banda Ancha</Tipo>" +
                                          "<Perfil xsi:type=\"xsd:string\">900_256</Perfil>" +
                                          "<ParametersFonosCabecera xsi:type=\"tns:ParametersTypeDCTFonosCabecera\">" +
                                             "<Vendor xsi:type=\"xsd:string\">ALCATEL</Vendor>" +
                                             "<DSLAM xsi:type=\"xsd:string\">WASHINGTON-4</DSLAM>" +
                                             "<Model xsi:type=\"xsd:string\">ASAM 7301</Model>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Vel. Act. Upstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\">0</Value>" +
                                             "</ParametersElectricos>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Vel. Max.Upstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\">0</Value>" +
                                             "</ParametersElectricos>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Ruido Upstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\">0</Value>" +
                                             "</ParametersElectricos>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Atenuacion Upstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\">0</Value>" +
                                             "</ParametersElectricos>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Ocupacion Upstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\">0</Value>" +
                                             "</ParametersElectricos>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Vel. Act. Downstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\">0</Value>" +
                                             "</ParametersElectricos>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Vel. Max. Downstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\">0</Value>" +
                                             "</ParametersElectricos>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Ruido Downstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\">0</Value>" +
                                             "</ParametersElectricos>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Atenuacion Downstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\">0</Value>" +
                                             "</ParametersElectricos>" +
                                             "<ParametersElectricos xsi:type=\"tns:ParametersElectricos\">" +
                                                "<Attribute xsi:type=\"xsd:string\">Ocupacion  Downstream:</Attribute>" +
                                                "<Value xsi:type=\"xsd:string\">0</Value>" +
                                             "</ParametersElectricos>" +
                                          "</ParametersFonosCabecera>" +
                                       "</ParametersFonos>" +
                                    "</Identification>" +
                                 "</Element>" +
                                "<Return xsi:type=\"tns:ReturnType\">" +
                                    "<Code xsi:type=\"xsd:string\">0</Code>" +
                                    "<Description xsi:nil=\"true\" xsi:type=\"xsd:string\"/>" +
                                "</Return>" +
                              "</Output>" +
                           "</ParaElectri>" +
                        "</Service>" +
                     "</ResponseParaElectri>" +
                  "</ns1:ParaElectriResponse>" +
               "</SOAP-ENV:Body>" +
            "</SOAP-ENV:Envelope>";
    
    public static String DCTRESOURCE = "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:tns=\"urn:Demo\">" +
               "<SOAP-ENV:Body>" +
                  "<ns1:DCTInformaResponse xmlns:ns1=\"urn:Demo\">" +
                     "<ResponseDCTInforma xsi:type=\"tns:ResponseDCTInforma\">" +
                        "<Operation xsi:type=\"tns:OperationType\">" +
                           "<OperationCode xsi:type=\"xsd:string\">?</OperationCode>" +
                           "<OperationId xsi:type=\"xsd:string\">?</OperationId>" +
                           "<DateTime xsi:type=\"xsd:string\">?</DateTime>" +
                           "<IdUser xsi:type=\"xsd:string\">?</IdUser>" +
                           "<IMEI xsi:type=\"xsd:string\">?</IMEI>" +
                           "<IMSI xsi:type=\"xsd:string\">?</IMSI>" +
                        "</Operation>" +
                        "<Service xsi:type=\"tns:ServiceDCTInformaOut\">" +
                           "<DCTInforma xsi:type=\"tns:DCTInformaOut\">" +
                              "<Output xsi:type=\"tns:DCTInformaOutData\">" +
                                 "<Element xsi:type=\"tns:ElementTypeDCTInforma\">" +
                                    "<Identification xsi:type=\"tns:IdentificationType\">" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">TIPO DE NODO</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">CAJA</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">CALLE</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">JR CONDE DE SUPERUNDA 654</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">ALTURA</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">0</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">PAR DESDE</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">21</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">PAR HASTA</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">40</Value>" +
                                       "</Parameters>" +
                                    "</Identification>" +
            "<SubElement xsi:type=\"tns:SubElementType\">" +
            "<Id xsi:type=\"xsd:string\">0</Id>" +
            "<Type xsi:type=\"xsd:string\">PAR</Type>" +
            "<Head xsi:type=\"xsd:string\">1</Head>" +
            "<Parameters xsi:type=\"tns:ParametersType\">" +
            "<Attribute xsi:type=\"xsd:string\">HEAD</Attribute>" +
            "<Value xsi:type=\"xsd:string\">PAR</Value>" +
            "</Parameters>" +
            "<Parameters xsi:type=\"tns:ParametersType\">" +
            "<Attribute xsi:type=\"xsd:string\">HEAD</Attribute>" +
            "<Value xsi:type=\"xsd:string\">TELEFONO</Value>" +
            "</Parameters>" +
            "<Parameters xsi:type=\"tns:ParametersType\">" +
            "<Attribute xsi:type=\"xsd:string\">HEAD</Attribute>" +
            "<Value xsi:type=\"xsd:string\">ESTADO</Value>" +
            "</Parameters>" +
            "<Parameters xsi:type=\"tns:ParametersType\">" +
            "<Attribute xsi:type=\"xsd:string\">HEAD</Attribute>" +
            "<Value xsi:type=\"xsd:string\"></Value>" +
            "</Parameters>" +
            "<Parameters xsi:type=\"tns:ParametersType\">" +
            "<Attribute xsi:type=\"xsd:string\">HEAD</Attribute>" +
            "<Value xsi:type=\"xsd:string\">ESTADO</Value>" +
            "</Parameters>" +
            "</SubElement>" +
            "<SubElement xsi:type=\"tns:SubElementType\">" +
            "<Id xsi:nil=\"true\" xsi:type=\"xsd:string\"/>" +
            "<Type xsi:type=\"xsd:string\">PAR2</Type>" +
            "<Head xsi:type=\"xsd:string\">0</Head>" +
            "<Parameters xsi:type=\"tns:ParametersType\">" +
            "<Attribute xsi:type=\"xsd:string\">PAR</Attribute>" +
            "<Value xsi:type=\"xsd:string\">2,327</Value>" +
            "</Parameters>" +
            "<Parameters xsi:type=\"tns:ParametersType\">" +
            "<Attribute xsi:type=\"xsd:string\">TELEFONO</Attribute>" +
            "<Value xsi:type=\"xsd:string\"/>" +
            "</Parameters>" +
            "<Parameters xsi:type=\"tns:ParametersType\">" +
            "<Attribute xsi:type=\"xsd:string\">ESTADO</Attribute>" +
            "<Value xsi:type=\"xsd:string\">OCUPADO</Value>" +
            "</Parameters>" +
            "<Parameters xsi:type=\"tns:ParametersType\">" +
            "<Attribute xsi:type=\"xsd:string\"></Attribute>" +
            "<Value xsi:type=\"xsd:string\"/>" +
            "</Parameters>" +
            "<Parameters xsi:type=\"tns:ParametersType\">" +
            "<Attribute xsi:type=\"xsd:string\">ESTADO</Attribute>" +
            "<Value xsi:type=\"xsd:string\">1</Value>" +
            "</Parameters>" +
            "</SubElement>" +
            "<SubElement xsi:type=\"tns:SubElementType\">" +
            "<Id xsi:nil=\"true\" xsi:type=\"xsd:string\"/>" +
            "<Type xsi:type=\"xsd:string\">PAR2</Type>" +
            "<Head xsi:type=\"xsd:string\">0</Head>" +
            "<Parameters xsi:type=\"tns:ParametersType\">" +
            "<Attribute xsi:type=\"xsd:string\">PAR</Attribute>" +
            "<Value xsi:type=\"xsd:string\">2,328</Value>" +
            "</Parameters>" +
            "<Parameters xsi:type=\"tns:ParametersType\">" +
            "<Attribute xsi:type=\"xsd:string\">TELEFONO</Attribute>" +
            "<Value xsi:type=\"xsd:string\">00222011108</Value>" +
            "</Parameters>" +
            "<Parameters xsi:type=\"tns:ParametersType\">" +
            "<Attribute xsi:type=\"xsd:string\">ESTADO</Attribute>" +
            "<Value xsi:type=\"xsd:string\">OCUPADO</Value>" +
            "</Parameters>" +
            "<Parameters xsi:type=\"tns:ParametersType\">" +
            "<Attribute xsi:type=\"xsd:string\"></Attribute>" +
            "<Value xsi:type=\"xsd:string\"/>" +
            "</Parameters>" +
            "<Parameters xsi:type=\"tns:ParametersType\">" +
            "<Attribute xsi:type=\"xsd:string\">ESTADO</Attribute>" +
            "<Value xsi:type=\"xsd:string\">2</Value>" +
            "</Parameters>" +
            "</SubElement>" +
            "<SubElement xsi:type=\"tns:SubElementType\">" +
            "<Id xsi:nil=\"true\" xsi:type=\"xsd:string\"/>" +
            "<Type xsi:type=\"xsd:string\">PAR2</Type>" +
            "<Head xsi:type=\"xsd:string\">0</Head>" +
            "<Parameters xsi:type=\"tns:ParametersType\">" +
            "<Attribute xsi:type=\"xsd:string\">PAR</Attribute>" +
            "<Value xsi:type=\"xsd:string\">2,329</Value>" +
            "</Parameters>" +
            "<Parameters xsi:type=\"tns:ParametersType\">" +
            "<Attribute xsi:type=\"xsd:string\">TELEFONO</Attribute>" +
            "<Value xsi:type=\"xsd:string\"/>" +
            "</Parameters>" +
            "<Parameters xsi:type=\"tns:ParametersType\">" +
            "<Attribute xsi:type=\"xsd:string\">ESTADO</Attribute>" +
            "<Value xsi:type=\"xsd:string\">VACANTE</Value>" +
            "</Parameters>" +
            "<Parameters xsi:type=\"tns:ParametersType\">" +
            "<Attribute xsi:type=\"xsd:string\"></Attribute>" +
            "<Value xsi:type=\"xsd:string\"/>" +
            "</Parameters>" +
            "<Parameters xsi:type=\"tns:ParametersType\">" +
            "<Attribute xsi:type=\"xsd:string\">ESTADO</Attribute>" +
            "<Value xsi:type=\"xsd:string\">1</Value>" +
            "</Parameters>" +
            "</SubElement>" +
            "<SubElement xsi:type=\"tns:SubElementType\">" +
            "<Id xsi:nil=\"true\" xsi:type=\"xsd:string\"/>" +
            "<Type xsi:type=\"xsd:string\">PAR2</Type>" +
            "<Head xsi:type=\"xsd:string\">0</Head>" +
            "<Parameters xsi:type=\"tns:ParametersType\">" +
            "<Attribute xsi:type=\"xsd:string\">PAR</Attribute>" +
            "<Value xsi:type=\"xsd:string\">2,330</Value>" +
            "</Parameters>" +
            "<Parameters xsi:type=\"tns:ParametersType\">" +
            "<Attribute xsi:type=\"xsd:string\">TELEFONO</Attribute>" +
            "<Value xsi:type=\"xsd:string\">00222113863</Value>" +
            "</Parameters>" +
            "<Parameters xsi:type=\"tns:ParametersType\">" +
            "<Attribute xsi:type=\"xsd:string\">ESTADO</Attribute>" +
            "<Value xsi:type=\"xsd:string\">OCUPADO ADSL</Value>" +
            "</Parameters>" +
            "<Parameters xsi:type=\"tns:ParametersType\">" +
            "<Attribute xsi:type=\"xsd:string\"></Attribute>" +
            "<Value xsi:type=\"xsd:string\"/>" +
            "</Parameters>" +
            "<Parameters xsi:type=\"tns:ParametersType\">" +
            "<Attribute xsi:type=\"xsd:string\">ESTADO</Attribute>" +
            "<Value xsi:type=\"xsd:string\">1</Value>" +
            "</Parameters>" +
            "</SubElement>" +
            "<SubElement xsi:type=\"tns:SubElementType\">" +
            "<Id xsi:nil=\"true\" xsi:type=\"xsd:string\"/>" +
            "<Type xsi:type=\"xsd:string\">PAR2</Type>" +
            "<Head xsi:type=\"xsd:string\">0</Head>" +
            "<Parameters xsi:type=\"tns:ParametersType\">" +
            "<Attribute xsi:type=\"xsd:string\">PAR</Attribute>" +
            "<Value xsi:type=\"xsd:string\">2,331</Value>" +
            "</Parameters>" +
            "<Parameters xsi:type=\"tns:ParametersType\">" +
            "<Attribute xsi:type=\"xsd:string\">TELEFONO</Attribute>" +
            "<Value xsi:type=\"xsd:string\">00222112206</Value>" +
            "</Parameters>" +
            "<Parameters xsi:type=\"tns:ParametersType\">" +
            "<Attribute xsi:type=\"xsd:string\">ESTADO</Attribute>" +
            "<Value xsi:type=\"xsd:string\">OCUPADO ADSL</Value>" +
            "</Parameters>" +
            "<Parameters xsi:type=\"tns:ParametersType\">" +
            "<Attribute xsi:type=\"xsd:string\"></Attribute>" +
            "<Value xsi:type=\"xsd:string\"/>" +
            "</Parameters>" +
            "<Parameters xsi:type=\"tns:ParametersType\">" +
            "<Attribute xsi:type=\"xsd:string\">ESTADO</Attribute>" +
            "<Value xsi:type=\"xsd:string\">1</Value>" +
            "</Parameters>" +
            "</SubElement>" +
                                 "</Element>" +
                                 "<Return xsi:type=\"tns:ReturnType\">" +
                                    "<Code xsi:type=\"xsd:string\">0</Code>" +
                                    "<Description xsi:nil=\"true\" xsi:type=\"xsd:string\"/>" +
                                 "</Return>" +
                              "</Output>" +
                           "</DCTInforma>" +
                        "</Service>" +
                     "</ResponseDCTInforma>" +
                  "</ns1:DCTInformaResponse>" +
               "</SOAP-ENV:Body>" +
            "</SOAP-ENV:Envelope>";

    public static String RESOURCE = "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:tns=\"urn:Demo\">" +
               "<SOAP-ENV:Body>" +
                  "<ns1:ResourceResponse xmlns:ns1=\"urn:Demo\">" +
                     "<ResponseResource xsi:type=\"tns:ResponseResource\">" +
                        "<Operation xsi:type=\"tns:OperationTypeResource\">" +
                           "<OperationCode xsi:type=\"xsd:string\">?</OperationCode>" +
                           "<OperationId xsi:type=\"xsd:string\">1</OperationId>" +
                           "<DateTime xsi:type=\"xsd:string\">?</DateTime>" +
                           "<IdUser xsi:type=\"xsd:string\">?</IdUser>" +
                           "<IMEI xsi:type=\"xsd:string\">?</IMEI>" +
                           "<IMSI xsi:type=\"xsd:string\">?</IMSI>" +
            "<!-- Etiqueta Cabecera--><BotonCertifica xsi:type=\"xsd:string\">false</BotonCertifica>" +
            "<!-- Etiqueta Cabecera--><BotonFact xsi:type=\"xsd:string\">true</BotonFact>" +
                        "</Operation>" +
                        "<Service xsi:type=\"tns:ServiceResourceOut\">" +
                           "<Resource xsi:type=\"tns:ResourceOut\">" +
                              "<Output xsi:type=\"tns:ResourceOutData\">" +
                                 "<Element xsi:type=\"tns:ElementTypeResource\">" +
                                    "<Id xsi:type=\"xsd:string\"/>" +
                                    "<Type xsi:type=\"xsd:string\">DIRECCION</Type>" +
                                    "<Value xsi:type=\"xsd:string\">DATOS DEL CLIENTE</Value>" +
                                    "<Identification xsi:type=\"tns:IdentificationType\">" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">TITULAR</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">MAGDALENA ESTER ALCAINO CAMPOS</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">CALLE</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">BERNARDINO CONCHA</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">NUMERO</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">1087</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">COMUNA</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">QUILLOTA</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">CIUDAD</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">QUILLOTA</Value>" +
                                       "</Parameters>" +
                                    "</Identification>" +
                                 "</Element>" +
                                 "<Element xsi:type=\"tns:ElementTypeResource\">" +
                                    "<Id xsi:type=\"xsd:string\"/>" +
                                    "<Type xsi:type=\"xsd:string\">PRODUCTOS</Type>" +
                                    "<Value xsi:type=\"xsd:string\">PRODUCTOS Y SERVICIOS</Value>" +
                                    "<Identification xsi:type=\"tns:IdentificationType\">" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">Cantidad de ps</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">17</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">439</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">BLOQUEO LDI + 700</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">1199</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">MODEM SPEEDY</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">1203</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">PROCESO PROVISION SPEEDY</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">1985</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">PLAN 100 MIN MOVILES</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">2989</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">SUITE DE SEGURIDAD</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">3123</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">1ER DECODIFICADOR DTH TVD</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">5099</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">DESCUENTO DECODIFICADOR TV</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">5223</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">MODEM INALAMBRICO SPY WIFI</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">5443</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">DECODIFICADOR ADICIONAL DTH NP</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">5679</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">PROTECCION FAMILIAR</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">5825</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">PLAN MIN ILIMITADO LOC HOGAR</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">6026</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">PLAN PREFERIDO TVD</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">6094</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">ANTIVIRUS MCAFEE</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">6616</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">BANDA ANCHA S 4 MEGA ADSL</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">6617</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">PLAN INTERNET S 4 MEGA ADSL</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">6943</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">DUO BA S MIN ILIM 4MG ADSL</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">7013</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">DECO ADICIONAL DTH STANDARD</Value>" +
                                       "</Parameters>" +
                                    "</Identification>" +
                                 "</Element>" +
                                 "<Element xsi:type=\"tns:ElementTypeResource\">" +
                                    "<Id xsi:type=\"xsd:string\"/>" +
                                    "<Type xsi:type=\"xsd:string\">PLANTA INTERNA</Type>" +
                                    "<Value xsi:type=\"xsd:string\">PLANTA INTERNA</Value>" +
                                    "<Gps xsi:type=\"tns:GPSType\">" +
                                       "<Lat xsi:type=\"xsd:string\"/>" +
                                       "<Lng xsi:type=\"xsd:string\"/>" +
                                    "</Gps>" +
                                    "<Identification xsi:type=\"tns:IdentificationType\">" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">PLANTA</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">QLLT</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">AGREGADOR</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">VPR2-PE</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">IP AGREGADOR</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">10.52.47.1</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">DSLAM</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">QUILLOTA_2</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">IP DSLAM</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">10.100.92.2</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">RACK / SHELF / SLOT / PORT</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">0 / 0 / 13 / 21</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">TIPO PUERTO</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">ADSL</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">MDF STB</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">12 / O / 10-0</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">MDF ADSL</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">17 / M / 74-75</Value>" +
                                       "</Parameters>" +
                                    "</Identification>" +
                                 "</Element>" +
                                 "<Element xsi:type=\"tns:ElementTypeResource\">" +
                                    "<Id xsi:type=\"xsd:string\"/>" +
                                    "<Type xsi:type=\"xsd:string\">PLANTA EXTERNA</Type>" +
                                    "<Value xsi:type=\"xsd:string\">PLANTA EXTERNA</Value>" +
                                    "<Gps xsi:type=\"tns:GPSType\">" +
                                       "<Lat xsi:type=\"xsd:string\">-32.8894</Lat>" +
                                       "<Lng xsi:type=\"xsd:string\">-71.2503</Lng>" +
                                    "</Gps>" +
                                    "<Identification xsi:type=\"tns:IdentificationType\">" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">PLANTA</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">QLLT</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">CABLE</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">1</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">PAR PRIMARIO</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">257</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">ARMARIO</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">A1</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">CALLE</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">SAN MARTIN</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">ALTURA</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">000410</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">PAR SECUNDARIO</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">644</Value>" +
                                       "</Parameters>" +
                                    "</Identification>" +
                                 "</Element>" +
                                 "<Element xsi:type=\"tns:ElementTypeResource\">" +
                                    "<Id xsi:type=\"xsd:string\">253869</Id>" +
                                    "<Type xsi:type=\"xsd:string\">CAJA</Type>" +
                                    "<Value xsi:type=\"xsd:string\">CAJA TERMINAL</Value>" +
                                    "<Gps xsi:type=\"tns:GPSType\">" +
                                       "<Lat xsi:type=\"xsd:string\">-32.8894</Lat>" +
                                       "<Lng xsi:type=\"xsd:string\">-71.2503</Lng>" +
                                    "</Gps>" +
                                 "</Element>" +
                                 "<Element xsi:type=\"tns:ElementTypeResource\">" +
                                    "<Id xsi:type=\"xsd:string\"/>" +
                                    "<Type xsi:type=\"xsd:string\">FAMILYSERVICE</Type>" +
                                    "<Value xsi:type=\"xsd:string\">SERVICIO BANDA ANCHA</Value>" +
            "<!-- Botones -->\t\t<Botones xsi:type=\"tns:BotonesResource\">" +
                                       "<Id xsi:type=\"xsd:string\">resetDslam</Id>" +
                                       "<Name xsi:type=\"xsd:string\">icono</Name>" +
                                       "<Enabled xsi:type=\"xsd:string\">false</Enabled>" +
                                    "</Botones>" +
                                    "<Identification xsi:type=\"tns:IdentificationType\">" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">MODEM</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">AMPER BHS ASL-26555</Value>" +
                                       "</Parameters>" +
                                    "</Identification>" +
                                 "</Element>" +
                                 "<Element xsi:type=\"tns:ElementTypeResource\">" +
                                    "<Id xsi:type=\"xsd:string\">0</Id>" +
                                    "<Type xsi:type=\"xsd:string\">FAMILYSERVICE</Type>" +
                                    "<Value xsi:type=\"xsd:string\">SERVICIO TELEVISION</Value>" +
            "<!-- Botones -->\t\t<Botones xsi:type=\"tns:BotonesResource\">" +
                                       "<Id xsi:type=\"xsd:string\">AgegarDeco</Id>" +
                                       "<Name xsi:type=\"xsd:string\">Agregar Deco</Name>" +
                                       "<Enabled xsi:type=\"xsd:string\">false</Enabled>" +
                                    "</Botones>" +
            "<!-- Botones -->\t\t<Botones xsi:type=\"tns:BotonesResource\">" +
                                       "<Id xsi:type=\"xsd:string\">ReactivarDeco</Id>" +
                                       "<Name xsi:type=\"xsd:string\">Reactivar Deco</Name>" +
                                       "<Enabled xsi:type=\"xsd:string\">false</Enabled>" +
                                    "</Botones>" +
            "<!-- Botones -->\t\t<Botones xsi:type=\"tns:BotonesResource\">" +
                                       "<Id xsi:type=\"xsd:string\">Lapiz</Id>" +
                                       "<Name xsi:type=\"xsd:string\">icono</Name>" +
                                       "<Enabled xsi:type=\"xsd:string\">false</Enabled>" +
                                    "</Botones>" +
                                    "<Identification xsi:type=\"tns:IdentificationType\">" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">MODEM</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">Kathrein  / SD Kathrein S292</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">SerieDeco</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">1859478261</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">SerieTarjeta</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">2408642508</Value>" +
                                       "</Parameters>" +
                                    "</Identification>" +
                                    "<Identification xsi:type=\"tns:IdentificationType\">" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">MODEM</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">ECHOSTAR / SD-646</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">SerieDeco</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">1769290676</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">SerieTarjeta</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">0323255032</Value>" +
                                       "</Parameters>" +
                                    "</Identification>" +
                                    "<Identification xsi:type=\"tns:IdentificationType\">" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">MODEM</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">Easy Digital / ED-S8</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">SerieDeco</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">1861626562</Value>" +
                                       "</Parameters>" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">SerieTarjeta</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">2407980092</Value>" +
                                       "</Parameters>" +
                                    "</Identification>" +
                                 "</Element>" +
                                 "<Element xsi:type=\"tns:ElementTypeResource\">" +
                                    "<Id xsi:type=\"xsd:string\"/>" +
                                    "<Type xsi:type=\"xsd:string\">FAMILYSERVICE</Type>" +
                                    "<Value xsi:type=\"xsd:string\">SERVICIO TELEFONIA</Value>" +
                                    "<Identification xsi:type=\"tns:IdentificationType\">" +
                                       "<Parameters xsi:type=\"tns:ParametersType\">" +
                                          "<Attribute xsi:type=\"xsd:string\">TELEFONO</Attribute>" +
                                          "<Value xsi:type=\"xsd:string\">332269032</Value>" +
                                       "</Parameters>" +
                                    "</Identification>" +
                                 "</Element>" +
                                 "<Return xsi:type=\"tns:ReturnType\">" +
                                    "<Code xsi:type=\"xsd:string\">0</Code>" +
                                    "<Description xsi:type=\"xsd:string\">OK:  ELEMENTOS DE PLANTA EXTERNA IDENTIFICADOS PARA [332269032]</Description>" +
                                 "</Return>" +
                              "</Output>" +
                           "</Resource>" +
                        "</Service>" +
                     "</ResponseResource>" +
                  "</ns1:ResourceResponse>" +
               "</SOAP-ENV:Body>" +
            "</SOAP-ENV:Envelope>";
}
