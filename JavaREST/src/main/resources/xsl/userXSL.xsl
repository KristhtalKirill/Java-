<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" omit-xml-declaration="yes"/>
    <xsl:template match="/">
        <div class="links">
            <div align="center">
                <h1>Users</h1>
            </div>
        </div>
        <div class="customer-input" align="center" valign="middle" style=" margin-left: 50px;">
            <table border="1" style="margin-top: 5px">
                <tr bgcolor="#CCCCCC">
                    <td>
                        <strong>User id</strong>
                    </td>
                    <td>
                        <strong>firstName</strong>
                    </td>
                    <td>
                        <strong>lastName</strong>
                    </td>
                    <td>
                        <strong>password</strong>
                    </td>
                    <td>
                        <strong>email</strong>
                    </td>
                    <td>
                        <strong>role</strong>
                    </td>
                </tr>
                <xsl:for-each select="ArrayList/item">
                    <tr>
                        <td>
                            <xsl:value-of select="id"/>
                        </td>
                        <td>
                            <xsl:value-of select="firstName"/>
                        </td>
                        <td>
                            <xsl:value-of select="lastName"/>
                        </td>
                        <td>
                            <xsl:value-of select="lastName"/>
                        </td>
                        <td>
                            <xsl:value-of select="email"/>
                        </td>
                        <td>
                            <xsl:value-of select="role"/>
                        </td>
                    </tr>
                </xsl:for-each>
            </table>
        </div>
        <div align="center">
            <p>
                <b>
                    <a href="/api/xsl/answer">Answers</a>
                </b>
            </p>
        </div>
    </xsl:template>
</xsl:stylesheet>