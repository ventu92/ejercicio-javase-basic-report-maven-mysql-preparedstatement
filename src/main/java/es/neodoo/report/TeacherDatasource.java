package es.neodoo.report;
import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import es.neodoo.model.vo.TeacherVO;

public class TeacherDatasource implements JRDataSource
{
    private List<TeacherVO> teachers = new ArrayList<TeacherVO>();
    private int indiceTeacherActual = -1;

    public Object getFieldValue(JRField jrf) throws JRException
    {
        Object valor = null;

        if ("nombre".equals(jrf.getName()))
        {
            valor = teachers.get(indiceTeacherActual).getNombre();
        }
        else if ("apellidos".equals(jrf.getName()))
        {
            valor = teachers.get(indiceTeacherActual).getApellidos();
        }

        return valor;
    }

    public boolean next() throws JRException
    {
        return ++indiceTeacherActual < teachers.size();
    }

    public void addTeacher(TeacherVO teacher)
    {
        this.teachers.add(teacher);
    }
}