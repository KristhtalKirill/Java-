<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" omit-xml-declaration="yes"/>
    <xsl:template match="/">
        <div class="links">
            <div align="center">
                <h1>Answers</h1>
            </div>
        </div>
        <div class="customer-input" align="center" valign="middle" style=" margin-left: 50px;">
            <table border="1" style="margin-top: 5px">
                <tr bgcolor="#CCCCCC">
                    <td>
                        <strong>Answer id</strong>
                    </td>
                    <td>
                        <strong>id_user</strong>
                    </td>
                    <td>
                        <strong>id_question</strong>
                    </td>
                    <td>
                        <strong>answer</strong>
                    </td>

                </tr>
                <xsl:for-each select="ArrayList/item">
                    <tr>
                        <td>
                            <xsl:value-of select="id"/>
                        </td>
                        <td>
                            <xsl:value-of select="id_user"/>
                        </td>
                        <td>
                            <xsl:value-of select="id_question"/>
                        </td>
                        <td>
                            <xsl:value-of select="answer"/>
                        </td>
                    </tr>
                </xsl:for-each>
            </table>
        </div>
        <div align="center">
            <p>
                <b>
                    <a href="/api/xsl/question">Questions</a>
                </b>
            </p>
        </div>
    </xsl:template>
</xsl:stylesheet>