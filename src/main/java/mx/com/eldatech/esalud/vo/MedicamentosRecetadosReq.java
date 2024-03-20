package mx.com.eldatech.esalud.vo;

import java.util.List;

public class MedicamentosRecetadosReq {

    private List<MedicamentosRecetadosVO> medicamentos;
    private SessionData sessionData;
    private Integer id_consulta;
    private List<String> indicacionesAdicionales;

    /**
     * @return the medicamentos
     */
    public List<MedicamentosRecetadosVO> getMedicamentos() {
        return medicamentos;
    }

    /**
     * @param medicamentos the medicamentos to set
     */
    public void setMedicamentos(List<MedicamentosRecetadosVO> medicamentos) {
        this.medicamentos = medicamentos;
    }

    /**
     * @return the id_consulta
     */
    public Integer getId_consulta() {
        return id_consulta;
    }

    /**
     * @param id_consulta the id_consulta to set
     */
    public void setId_consulta(Integer id_consulta) {
        this.id_consulta = id_consulta;
    }

    public SessionData getSessionData() {
        return sessionData;
    }

    public void setSessionData(SessionData sessionData) {
        this.sessionData = sessionData;
    }

    public List<String> getIndicacionesAdicionales() {
        return indicacionesAdicionales;
    }

    public void setIndicacionesAdicionales(List<String> indicacionesAdicionales) {
        this.indicacionesAdicionales = indicacionesAdicionales;
    }
}
