package io.github.jhipster.application.service.dto;
import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.application.domain.enumeration.TipoEntradad;
import io.github.jhipster.application.domain.enumeration.TipoIngresod;

/**
 * A DTO for the {@link io.github.jhipster.application.domain.EntradaInvitados} entity.
 */
public class EntradaInvitadosDTO implements Serializable {

    private Long id;

    @NotNull
    private ZonedDateTime registroFecha;

    private TipoEntradad tipoEntrada;

    private TipoIngresod tipoIngreso;

    private Boolean tiempoMaximo;


    private Long espacioId;

    private String espacioNombre;

    private Long espacioReservaId;

    private String espacioReservaNombre;

    private Long invitadoId;

    private String invitadoIdentificacion;

    private Long miembroId;

    private String miembroLogin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getRegistroFecha() {
        return registroFecha;
    }

    public void setRegistroFecha(ZonedDateTime registroFecha) {
        this.registroFecha = registroFecha;
    }

    public TipoEntradad getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(TipoEntradad tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    public TipoIngresod getTipoIngreso() {
        return tipoIngreso;
    }

    public void setTipoIngreso(TipoIngresod tipoIngreso) {
        this.tipoIngreso = tipoIngreso;
    }

    public Boolean isTiempoMaximo() {
        return tiempoMaximo;
    }

    public void setTiempoMaximo(Boolean tiempoMaximo) {
        this.tiempoMaximo = tiempoMaximo;
    }

    public Long getEspacioId() {
        return espacioId;
    }

    public void setEspacioId(Long espacioLibreId) {
        this.espacioId = espacioLibreId;
    }

    public String getEspacioNombre() {
        return espacioNombre;
    }

    public void setEspacioNombre(String espacioLibreNombre) {
        this.espacioNombre = espacioLibreNombre;
    }

    public Long getEspacioReservaId() {
        return espacioReservaId;
    }

    public void setEspacioReservaId(Long espaciosReservaId) {
        this.espacioReservaId = espaciosReservaId;
    }

    public String getEspacioReservaNombre() {
        return espacioReservaNombre;
    }

    public void setEspacioReservaNombre(String espaciosReservaNombre) {
        this.espacioReservaNombre = espaciosReservaNombre;
    }

    public Long getInvitadoId() {
        return invitadoId;
    }

    public void setInvitadoId(Long invitadosId) {
        this.invitadoId = invitadosId;
    }

    public String getInvitadoIdentificacion() {
        return invitadoIdentificacion;
    }

    public void setInvitadoIdentificacion(String invitadosIdentificacion) {
        this.invitadoIdentificacion = invitadosIdentificacion;
    }

    public Long getMiembroId() {
        return miembroId;
    }

    public void setMiembroId(Long userId) {
        this.miembroId = userId;
    }

    public String getMiembroLogin() {
        return miembroLogin;
    }

    public void setMiembroLogin(String userLogin) {
        this.miembroLogin = userLogin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EntradaInvitadosDTO entradaInvitadosDTO = (EntradaInvitadosDTO) o;
        if (entradaInvitadosDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), entradaInvitadosDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EntradaInvitadosDTO{" +
            "id=" + getId() +
            ", registroFecha='" + getRegistroFecha() + "'" +
            ", tipoEntrada='" + getTipoEntrada() + "'" +
            ", tipoIngreso='" + getTipoIngreso() + "'" +
            ", tiempoMaximo='" + isTiempoMaximo() + "'" +
            ", espacio=" + getEspacioId() +
            ", espacio='" + getEspacioNombre() + "'" +
            ", espacioReserva=" + getEspacioReservaId() +
            ", espacioReserva='" + getEspacioReservaNombre() + "'" +
            ", invitado=" + getInvitadoId() +
            ", invitado='" + getInvitadoIdentificacion() + "'" +
            ", miembro=" + getMiembroId() +
            ", miembro='" + getMiembroLogin() + "'" +
            "}";
    }
}