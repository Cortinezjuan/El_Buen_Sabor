package com.app.elbuensabor.Servicio;

import com.app.elbuensabor.Dto.PedidoDto;
import com.app.elbuensabor.Dto.PedidoRespDto;
import com.app.elbuensabor.Dto.PedidosPorUsuariosDto;
import com.app.elbuensabor.Dto.RankingComidasDto;
import com.app.elbuensabor.Entidad.DetallePedido;
import com.app.elbuensabor.Entidad.Domicilio;
import com.app.elbuensabor.Entidad.Pedido;
import com.app.elbuensabor.Entidad.Usuario;
import com.app.elbuensabor.Repositorio.DomicilioRepositorio;
import com.app.elbuensabor.Repositorio.PedidoRepositorio;
import com.app.elbuensabor.Repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.objenesis.ObjenesisSerializer;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.*;

@Service
public class PedidoServicio {

    @Autowired
    PedidoRepositorio pedidoRepositorio;
    @Autowired
    UsuarioRepositorio usuarioRepositorio;
    @Autowired
    DomicilioRepositorio domicilioRepositorio;


    public List<PedidoRespDto> listarPedidos() {
        List<Pedido> pedidos = pedidoRepositorio.listarPedidos();
        List<PedidoRespDto> pedidosDto = new ArrayList<>();
        for(Pedido aux:pedidos){
            String estado ="";
            if(aux.getEstadoPedido()==1)estado = "En Preparación";
            if(aux.getEstadoPedido()==6)estado = "Pagado";
            String horaFin = aux.getHoraEstimadaFinPedido().getHours()+":"+aux.getHoraEstimadaFinPedido().getMinutes();
            String fechaInicio = String.valueOf(aux.getFechaPedido().getTime());
            PedidoRespDto pedidoDto = PedidoRespDto.builder()
                    .idPedido(aux.getIdPedido())
                    .fechaPedido(aux.getFechaPedido().toString())
                    .estadoPedido(estado)
                    .numeroPedido(aux.getIdPedido())
                    .horaEstimadaFinPedido(horaFin)
                    .nombreUsuario(aux.getUsuario().getUsuario())
                    .totalPedido(aux.getTotalPedido())
                    .build();
            pedidosDto.add(pedidoDto);
        }
        return pedidosDto;
    }

    public Optional<Pedido> listarPedidoPorId(int id) {
        return pedidoRepositorio.findById(id);
    }

    public PedidoDto guardarPedido(PedidoDto pedidoDto) {
        Usuario usuario = usuarioRepositorio.findByUsuario(pedidoDto.getNombreUsuario());
        Domicilio domicilio = domicilioRepositorio.findByidUsuario(usuario.getIdUsuario());
        Calendar calendar = Calendar.getInstance();
        //calendar.setTime(new Date());
        calendar.add(Calendar.MINUTE,pedidoDto.getHoraEstimadaFinPedido());

        Pedido pedido = Pedido.builder()
                .estadoPedido(1)
                .fechaPedido(new Date())
                .horaEstimadaFinPedido(calendar.getTime())
                .tipoEnvio(1)
                .totalPedido(pedidoDto.getTotalPedido())
                .domicilio(domicilio)
                .usuario(usuario)

                .build();
        pedidoRepositorio.save(pedido);
        return pedidoDto;
    }

    public void borrarPedido(int id) {
        Optional<Pedido> pedido = pedidoRepositorio.findById(id);
        pedido.get().setBajaPedido(true);
        pedidoRepositorio.save(pedido.get());
    }

    public Pedido modificarPedido(Pedido pedido) {
        return pedidoRepositorio.save(pedido);
    }

    public List<PedidosPorUsuariosDto> pedidosPorUsuarioPorFecha(Date fecha1, Date fecha2) {
        List<String> pedidosDB = pedidoRepositorio.buscarPedidosAgrupadosPorId(fecha1,fecha2);
        List<PedidosPorUsuariosDto> pedidos = new ArrayList<>();
        for(String aux: pedidosDB){
            String[] textElement = aux.split(",");
            PedidosPorUsuariosDto pedidoDto = PedidosPorUsuariosDto.builder()
                    .id_usuario(Integer.parseInt(textElement[0]))
                    .nombreUsuario(textElement[1])
                    .apellidoUsuario(textElement[2])
                    .cantidadPedidos(Integer.parseInt(textElement[3]))
                    .build();
            pedidos.add(pedidoDto);
        }
        return pedidos;
    }
    public List<RankingComidasDto>rankingComidasPorFechas(Date fecha1, Date fecha2){
        List<String> pedidosDB = pedidoRepositorio.rankingComidasPorFechas(fecha1,fecha2);
        List<RankingComidasDto> comidas = new ArrayList<>();
        for(String aux: pedidosDB){
            String[] textElement = aux.split(",");
            RankingComidasDto comidaDto = RankingComidasDto.builder()
                    .nombreComida(textElement[0])
                    .cantPedida(Integer.parseInt(textElement[1]))
                    .build();
            comidas.add(comidaDto);
        }

        return comidas;
    }

    public int getIdUltimoPedido(){
        return pedidoRepositorio.findIdUltimoPedido();
    }

    public void pagarPedido(int id){
        System.out.println("id pedido" + id);
       Optional<Pedido> pedido = pedidoRepositorio.findById(id);
       pedido.get().setNumeroPedido(id);
       pedido.get().setEstadoPedido(6);
       pedidoRepositorio.save(pedido.get());
    }

    public List<PedidoRespDto> listarPedidosPorUsuario(String nombreUsuario) {
        List<Pedido> pedidos = pedidoRepositorio.findByidUsuario(usuarioRepositorio.findByUsuario(nombreUsuario).getIdUsuario());
        List<PedidoRespDto> pedidosDto = new ArrayList<>();
        for(Pedido aux:pedidos){
            String estado ="";
            if(aux.getEstadoPedido()==1)estado = "En Preparación";
            if(aux.getEstadoPedido()==6)estado = "Pagado";
            String horaFin = aux.getHoraEstimadaFinPedido().getHours()+":"+aux.getHoraEstimadaFinPedido().getMinutes();
            String fechaInicio = String.valueOf(aux.getFechaPedido().getTime());
            PedidoRespDto pedidoDto = PedidoRespDto.builder()
                    .idPedido(aux.getIdPedido())
                    .fechaPedido(aux.getFechaPedido().toString())
                    .estadoPedido(estado)
                    .numeroPedido(aux.getIdPedido())
                    .horaEstimadaFinPedido(horaFin)
                    .nombreUsuario(aux.getUsuario().getUsuario())
                    .totalPedido(aux.getTotalPedido())
                    .build();
            pedidosDto.add(pedidoDto);
        }
        return pedidosDto;
    }
}
