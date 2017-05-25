package eu.faerierose.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author FaerieRose
 * @since 2017-05-25
 */
@Entity
public class Code {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(unique=true, nullable=false, length=8)
	private String code;

	/* =================================================================== */
	/* Getters & Setters                                                   */ 
	/* =================================================================== */
	public long getId() {
		return id;
	}
	/* =================================================================== */
	public String getCode() {
		return code;
	}
}



/*

INSERT INTO `code` (`id`, `code`) VALUES (NULL, '32457168');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '78390441');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '47602728');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '41371938');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '35287038');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '68146983');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '63540981');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '69585183');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '79671663');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '57173148');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '46866231');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '63997353');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '56098251');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '71652528');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '54829251');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '61046226');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '36404226');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '33933438');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '33578118');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '65017728');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '23116104');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '64297683');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '51567921');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '27826911');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '16547571');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '61274178');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '56834271');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '59168763');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '32111244');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '43841781');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '47487573');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '19860138');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '23854941');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '16856361');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '32250366');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '31040586');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '26080398');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '54707058');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '44621046');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '24046236');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '67271841');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '55379151');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '22324626');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '26832861');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '57938301');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '23530176');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '25255548');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '38369763');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '76081338');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '63282951');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '63592218');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '23555088');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '32741046');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '55870308');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '19322928');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '31771908');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '69852141');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '24402024');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '71961318');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '16843671');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '42957711');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '11236104');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '75112668');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '24122376');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '57269493');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '63984663');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '64692018');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '66907593');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '29488833');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '54660528');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '71200386');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '73174851');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '25382448');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '46452168');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '32871708');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '18687483');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '19267461');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '38814381');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '46713951');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '49965885');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '23145246');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '79895385');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '17203698');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '36416448');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '23486931');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '63392931');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '28339218');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '64873431');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '79075701');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '66294711');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '57569823');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '44836308');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '56838501');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '47280771');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '47758293');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '52989201');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '79845093');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '55734471');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '56783511');
INSERT INTO `code` (`id`, `code`) VALUES (NULL, '26368038');


*/