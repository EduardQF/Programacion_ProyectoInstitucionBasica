<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/*">
        <HTML>
            <HEAD>
                <TITLE>Name of students</TITLE>
            </HEAD>
            <BODY>
                <xsl:apply-templates select="/"/>
            </BODY>
        </HTML>
    </xsl:template>
    <xsl:template match="student">
        <P>
            <xsl:value-of select="/"/>
        </P>
    </xsl:template>
</xsl:stylesheet> 