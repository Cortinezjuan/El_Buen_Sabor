package com.app.elbuensabor.Servicio;

import com.app.elbuensabor.Dto.PedidoDto;
import com.app.elbuensabor.Dto.PedidoRespDto;
import com.app.elbuensabor.Dto.PedidosPorUsuariosDto;
import com.app.elbuensabor.Dto.RankingComidasDto;
import com.app.elbuensabor.Entidad.Domicilio;
import com.app.elbuensabor.Entidad.Estado;
import com.app.elbuensabor.Entidad.Pedido;
import com.app.elbuensabor.Entidad.Usuario;
import com.app.elbuensabor.Repositorio.DomicilioRepositorio;
import com.app.elbuensabor.Repositorio.EstadoRepositorio;
import com.app.elbuensabor.Repositorio.PedidoRepositorio;
import com.app.elbuensabor.Repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
public class PedidoServicio {

    @Autowired
    PedidoRepositorio pedidoRepositorio;
    @Autowired
    UsuarioRepositorio usuarioRepositorio;
    @Autowired
    DomicilioRepositorio domicilioRepositorio;
    @Autowired
    EstadoRepositorio estadoRepositorio;


    public List<PedidoRespDto> listarPedidos() {
        List<Pedido> pedidos = pedidoRepositorio.listarPedidos();
        List<PedidoRespDto> pedidosDto = new ArrayList<>();
        for(Pedido aux:pedidos){
            String estado =aux.getEstado().getEstado();
            //if(aux.getEstadoPedido()==1)estado = "En Preparación";
            //if(aux.getEstadoPedido()==6)estado = "Pagado";
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

    public PedidoRespDto listarPedidoPorId(int id) {
        Optional<Pedido> pedido = pedidoRepositorio.findById(id);
        String estado ="";
        //if(pedido.get().getEstadoPedido()==1)estado = "En Preparación";
        //if(pedido.get().getEstadoPedido()==6)estado = "Pagado";
        String horaFin = pedido.get().getHoraEstimadaFinPedido().getHours()+":"+pedido.get().getHoraEstimadaFinPedido().getMinutes();
        String fechaInicio = String.valueOf(pedido.get().getFechaPedido().getTime());
        PedidoRespDto pedidoDto = PedidoRespDto.builder()
                .idPedido(pedido.get().getIdPedido())
                .fechaPedido(pedido.get().getFechaPedido().toString())
                .estadoPedido(pedido.get().getEstado().getEstado())
                .numeroPedido(pedido.get().getIdPedido())
                .horaEstimadaFinPedido(horaFin)
                .nombreUsuario(pedido.get().getUsuario().getUsuario())
                .totalPedido(pedido.get().getTotalPedido())
                .build();
        return pedidoDto;
    }

    public PedidoDto guardarPedido(PedidoDto pedidoDto) {
        Usuario usuario = usuarioRepositorio.findByUsuario(pedidoDto.getNombreUsuario());
        Domicilio domicilio = domicilioRepositorio.findByidUsuario(usuario.getIdUsuario());
        Optional<Estado> estado = estadoRepositorio.findById(pedidoDto.getEstadoPedido());

        Calendar calendar = Calendar.getInstance();
        //calendar.setTime(new Date());
        calendar.add(Calendar.MINUTE,pedidoDto.getHoraEstimadaFinPedido());

        Pedido pedido = Pedido.builder()
                .estado(estado.get())
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

    public Pedido modificarPedido(PedidoDto pedidoDto) {
        Optional<Pedido> pedido = pedidoRepositorio.findById(pedidoDto.getIdPedido());
        Optional<Estado> estado = estadoRepositorio.findById(pedidoDto.getEstadoPedido());
        pedido.get().setEstado(estado.get());
        return pedidoRepositorio.save(pedido.get());
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
       //pedido.get().setEstadoPedido(6);
       pedidoRepositorio.save(pedido.get());
    }

    public List<PedidoRespDto> listarPedidosPorUsuario(String nombreUsuario) {
        List<Pedido> pedidos = pedidoRepositorio.findByidUsuario(usuarioRepositorio.findByUsuario(nombreUsuario).getIdUsuario());
        List<PedidoRespDto> pedidosDto = new ArrayList<>();
        for(Pedido aux:pedidos){
            String estado ="";
            //if(aux.getEstadoPedido()==1)estado = "En Preparación";
            //if(aux.getEstadoPedido()==6)estado = "Pagado";
            String horaFin = aux.getHoraEstimadaFinPedido().getHours()+":"+aux.getHoraEstimadaFinPedido().getMinutes();
            String fechaInicio = String.valueOf(aux.getFechaPedido().getTime());
            PedidoRespDto pedidoDto = PedidoRespDto.builder()
                    .idPedido(aux.getIdPedido())
                    .fechaPedido(aux.getFechaPedido().toString())
                    .estadoPedido(aux.getEstado().getEstado())
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
