<?php
/**
 * helpsms.php receives a message from a quitter and sends back a message from someone else
 *
 * @author		Rob Finean	<rfinean@iee.org>
 *
 * @version		1.0	14/Apr/12	1st stab at Twilio
 */

	$senderNo = $_REQUEST['From'];

    header("content-type: text/xml");
    echo "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
?>
<Response>
    <Sms>Distract yourself by slowly sipping from a glass of cold water until the craving is over</Sms>
</Response>