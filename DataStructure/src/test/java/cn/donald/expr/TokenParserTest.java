package cn.donald.expr;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TokenParserTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		TokenParser parser = new TokenParser();
		List<Token> tokens  = parser.parse("300*20+12*5-20/4");
		
		assertEquals(300, tokens.get(0).getIntValue());
		assertEquals("*", tokens.get(1).toString());
		assertEquals(20, tokens.get(2).getIntValue());
		assertEquals("+", tokens.get(3).toString());
		assertEquals(12, tokens.get(4).getIntValue());
		assertEquals("*", tokens.get(5).toString());
		assertEquals(5, tokens.get(6).getIntValue());
		assertEquals("-", tokens.get(7).toString());
		assertEquals(20, tokens.get(8).getIntValue());
		assertEquals("/", tokens.get(9).toString());
		assertEquals(4, tokens.get(10).getIntValue());
	}



}
