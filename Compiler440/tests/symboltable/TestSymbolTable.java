package symboltable;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import symboltable.method.impl.PublicMethod;
import symboltable.variable.impl.InstanceObjectVariable;
import symboltable.variable.impl.InstancePrimitiveVariable;
import symboltable.variable.impl.LocalObjectVariable;
import symboltable.variable.impl.LocalPrimitiveVariable;
import symboltable.variable.impl.MethodPrimitiveVariable;

/**
 * @author Ian Keefer, Curtis Rabe, Mike Zimmerman
 */
public class TestSymbolTable {

	/**
	 * Test the initialization of a symbol table.
	 */
	@Test
	public void testInitialization() {
		assertNotNull(SymbolTable.getInstance());
		assertNotNull(SymbolTable.getInstance().getVariableTable());
		//Added by Curtis Rabe
		assertNotNull(SymbolTable.getInstance().getMethodTable());
		assertNotNull(SymbolTable.getInstance().getClassTable());
	}
	
	/**
	 * Test the storing of parameters from methods into the symbol table
	 */
	@Test
	public void testStoringParams()
	{
		MethodPrimitiveVariable mpv1 = new MethodPrimitiveVariable("Name1", "ClassName", "MethodName", VariableScope.METHOD, VariableType.INTEGER);
		ArrayList<Variable> params = new ArrayList<Variable>();
		params.add(mpv1);
		SymbolTable.getInstance().getVariableTable().put(mpv1.getName(), params);
		assertEquals(mpv1, SymbolTable.getInstance().getVariableTable().get("Name1").get(0));
	}
	
	/**
	 * Test the order of parameters from methods being stored in the symbol table
	 */
	@Test
	public void testOrderParams()
	{
		MethodPrimitiveVariable mpv1 = new MethodPrimitiveVariable("Name1", "ClassName", "MethodName", VariableScope.METHOD, VariableType.INTEGER);
		MethodPrimitiveVariable mpv2 = new MethodPrimitiveVariable("Name2", "ClassName", "MethodName", VariableScope.METHOD, VariableType.BOOLEAN);
		ArrayList<Variable> params = new ArrayList<Variable>();
		params.add(mpv1);
		params.add(mpv2);
		SymbolTable.getInstance().getVariableTable().put("Method1", params);
		assertEquals(mpv1, SymbolTable.getInstance().getVariableTable().get("Method1").get(0));
		assertEquals(mpv2, SymbolTable.getInstance().getVariableTable().get("Method1").get(1));
	}
	
	/**
	 * Test the storing of parameters from methods into the symbol table
	 */
	@Test
	public void testStoringNoParams()
	{
		MethodPrimitiveVariable mpv1 = new MethodPrimitiveVariable("Name1", "ClassName", "MethodName", VariableScope.METHOD, VariableType.INTEGER);
		ArrayList<Variable> params = new ArrayList<Variable>();
		//Note: No parameters added to "params"
		SymbolTable.getInstance().getVariableTable().put(mpv1.getName(), params);
		assertEquals(0, SymbolTable.getInstance().getVariableTable().get(mpv1.getName()).size());
	}
	
	/**
	 * Test the storing of variables into the symbol table
	 */
	@Test
	public void testStoringVars()
	{
		MethodPrimitiveVariable mpv1 = new MethodPrimitiveVariable("Name1", "ClassName", "MethodName", VariableScope.METHOD, VariableType.INTEGER);
		LocalPrimitiveVariable lpv1 = new LocalPrimitiveVariable("Name2", "ClassName", "MethodName", VariableScope.LOCAL, VariableType.INTEGER);
		LocalPrimitiveVariable lpv2 = new LocalPrimitiveVariable("Name3", "ClassName", "MethodName", VariableScope.LOCAL, VariableType.INTEGER);
		LocalObjectVariable lov1 = new LocalObjectVariable("Name4", "ClassName", "id", "MethodName", VariableScope.LOCAL, VariableType.OBJECT);
		ArrayList<Variable> vars = new ArrayList<Variable>();
		vars.add(mpv1);
		vars.add(lpv1);
		vars.add(lpv2);
		vars.add(lov1);
		//passes in the method name and the list of variables within it
		SymbolTable.getInstance().getVariableTable().put("MethodName", vars);
		assertEquals(mpv1, SymbolTable.getInstance().getVariableTable().get("MethodName").get(0));
		assertEquals(lpv1, SymbolTable.getInstance().getVariableTable().get("MethodName").get(1));
		assertEquals(lpv2, SymbolTable.getInstance().getVariableTable().get("MethodName").get(2));
		assertEquals(lov1, SymbolTable.getInstance().getVariableTable().get("MethodName").get(3));
	}
	
	/**
	 * By Mike Zimmerman
	 * Test to make sure a class can be stored in the symbol table 
	 */
	@Test
	public void testStoringClasses()
	{
		Class cla1 = new Class("Name1", null, null , null );
		ArrayList<Class> list = new ArrayList<Class>();
		list.add(cla1);
		SymbolTable.getInstance().getClassTable().put("list of classes", list);
		assertEquals(1, SymbolTable.getInstance().getClassTable().get("list of classes").size());	
	}
	
	/**
	 * By Mike Zimmerman -- sorry for the nesting of calls
	 * test to make sure the instance vars from a class are stored and retrievable  
	 */
	@Test
	public void testInstanceVarsInClasses()
	{
//		InstancePrimitiveVariable(String name, String className, VariableScope scope, VariableType type) 
		InstancePrimitiveVariable ipv = new InstancePrimitiveVariable("Name1", "cla1", VariableScope.INSTANCE, VariableType.INTEGER);
		
		ArrayList<InstancePrimitiveVariable> vars = new ArrayList<InstancePrimitiveVariable>();
		vars.add(ipv);
		
		Class cla1 = new Class("Name1", null, vars , null );
		ArrayList<Class> list = new ArrayList<Class>();
		list.add(cla1);
		SymbolTable.getInstance().getClassTable().put("list of classes", list);
		assertEquals(1, SymbolTable.getInstance().getClassTable().get("list of classes").get(0).getVars().size());	
		assertEquals("Name1", SymbolTable.getInstance().getClassTable().get("list of classes").get(0).getVars().get(0).getName());	
		assertEquals("cla1", SymbolTable.getInstance().getClassTable().get("list of classes").get(0).getVars().get(0).getClassName());	
		assertEquals(VariableScope.INSTANCE, SymbolTable.getInstance().getClassTable().get("list of classes").get(0).getVars().get(0).getScope());	
		assertEquals(VariableType.INTEGER, SymbolTable.getInstance().getClassTable().get("list of classes").get(0).getVars().get(0).getType());	
		
	}
	
	/**
	 * By Mike Zimmerman -- sorry for the nesting of calls
	 * test to make sure the methods from a class are stored and retrievable
	 *  **Upon doing this test I am questioning if separate HashMaps for each 
	 * type of primary thing stored in the symbol table.**     
	 */
	@Test
	public void testStoingMethodsInClasses()
	{
		Class cla1 = new Class("cla1", null, null, null );
		ArrayList<Variable> params = new ArrayList<Variable>();
		
		PublicMethod meth1 = new PublicMethod("Name1", cla1, VariableType.INTEGER, params);
		
		ArrayList<Method> methods = new ArrayList<Method>();
		methods.add(meth1);
		
		cla1.setMethods(methods);
		ArrayList<Class> list = new ArrayList<Class>();
		list.add(cla1);
		SymbolTable.getInstance().getClassTable().put("list of classes", list);
		
		assertEquals(1, SymbolTable.getInstance().getClassTable().get("list of classes").get(0).getMethods().size());	
		assertEquals("Name1", SymbolTable.getInstance().getClassTable().get("list of classes").get(0).getMethods().get(0).getMethodName());	
		assertEquals("cla1", SymbolTable.getInstance().getClassTable().get("list of classes").get(0).getMethods().get(0).getClassName());		
		assertEquals(VariableType.INTEGER, SymbolTable.getInstance().getClassTable().get("list of classes").get(0).getMethods().get(0).getType());
		assertEquals(params, SymbolTable.getInstance().getClassTable().get("list of classes").get(0).getMethods().get(0).getParams());
		
	}
}