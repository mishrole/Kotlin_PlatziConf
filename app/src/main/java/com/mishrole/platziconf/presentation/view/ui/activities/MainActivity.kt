package com.mishrole.platziconf.presentation.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.mishrole.platziconf.R
import com.mishrole.platziconf.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appToolbar.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContent) as NavHostFragment
        val navController = navHostFragment.navController

        NavigationUI.setupWithNavController(binding.bnvMenu, navController)

        /*

        val jsonArr = JSONArray(
            "[\n" +
                    "            {\n" +
                    "                'biography' : 'Cesar Fajardo, creativo y content creator del equipo de Platzi, transforma las ideas en historias inspiradoras y contenidos innovadores que impactan al mundo para generar gracias, no solo likes, de nada sirve tu talento si no estas haciendo algo con el, de nada sirven tus habilidades si no tienes ideas para fusionarlas.',\n" +
                    "                'category' : 5,\n" +
                    "                'image' : 'https://pbs.twimg.com/profile_images/1015273976438902784/T0gZSbTP_400x400.jpg',\n" +
                    "                'jobtitle' : 'Content Creator',\n" +
                    "                'name' : 'Cesar Fajardo',\n" +
                    "                'twitter' : 'fajardocesar',\n" +
                    "                'workplace' : 'Platzi'\n" +
                    "            },\n" +
                    "            {\n" +
                    "                'biography' : 'Soy Win. Gre??udo, flaco y ojeroso. Hago fotograf??a los domingos. Head of production at @platzi',\n" +
                    "                'category' : 12,\n" +
                    "                'image' : 'https://pbs.twimg.com/profile_images/902939605221199872/eJypBkO__400x400.jpg',\n" +
                    "                'jobtitle' : 'Head of Production',\n" +
                    "                'name' : 'Ludwin Cuevas',\n" +
                    "                'twitter' : 'winiberto',\n" +
                    "                'workplace' : 'Platzi'\n" +
                    "            },\n" +
                    "            {\n" +
                    "                'biography' : 'CEO y Fundador de Capptu el banco de fotograf??as que las conecta con las marcas y que adem??s que fue reconocido por la revista Forbes M??xico como promesa de negocios del 2018.',\n" +
                    "                'category' : 10,\n" +
                    "                'image' : 'https://pbs.twimg.com/profile_images/1042801434989879296/Dya62rEB_400x400.jpg',\n" +
                    "                'jobtitle' : 'Founder & CEO',\n" +
                    "                'name' : 'Manuel Villegas',\n" +
                    "                'twitter' : 'manvillegasmx',\n" +
                    "                'workplace' : 'Capptu'\n" +
                    "            },\n" +
                    "            {\n" +
                    "                'biography' : 'L??der del equipo de Growth en Platzi y Google Doc Expert en Marketing, especialista en an??lisis de datos, presupuesto y proyecciones de Startups, lo que lo ha llevado a ser un gran conferencista a nivel mundial. Recuerden si estamos haciendo algo y no estamos aprendiendo de ello, no sirve de nada.',\n" +
                    "                'category' : 9,\n" +
                    "                'image' : 'https://pbs.twimg.com/profile_images/1128429578647736321/5ZwuI5_Q_400x400.jpg',\n" +
                    "                'jobtitle' : 'Head of Growth',\n" +
                    "                'name' : 'Juan Pablo Rojas',\n" +
                    "                'twitter' : 'UnMalNick',\n" +
                    "                'workplace' : 'Platzi'\n" +
                    "            },\n" +
                    "            {\n" +
                    "                'biography' : 'Pablo Villanueva es Google Developer Expert, Co-fundador y Chief Technology en Metix Medical. Es un gran facilitador de equipos con metodolog??as ??giles y reconocido profesor de Platzi. SRE en Globant. Google Developer Expert y Google Cloud Authorized Trainer. Organizador en GDG Cloud MX.',\n" +
                    "                'category' : 6,\n" +
                    "                'image' : 'https://pbs.twimg.com/profile_images/1225834733549965312/JixgS3m__400x400.jpg',\n" +
                    "                'jobtitle' : 'Co-founder & CTO',\n" +
                    "                'name' : 'Pablo Villanueva',\n" +
                    "                'twitter' : 'pablovillamx',\n" +
                    "                'workplace' : 'Metix'\n" +
                    "            },\n" +
                    "            {\n" +
                    "                'biography' : 'Co-fundadora de Fitco, donde estamos ayudando a Fitness Boutiques a crecer a trav??s de la tecnolog??a. Trabajando y apasionado por el crecimiento de SaaS a trav??s de ventas, inbound marketing y asociaciones.',\n" +
                    "                'category' : 11,\n" +
                    "                'image' : 'https://media-exp2.licdn.com/dms/image/C4E03AQE3a2dbco8Niw/profile-displayphoto-shrink_800_800/0?e=1585180800&v=beta&t=Pb0KFPrtO-FR2zUlk_rPSPmZU_LAdpowWAt9s2LgzKA',\n" +
                    "                'jobtitle' : 'CEO',\n" +
                    "                'name' : 'Andrea Baba',\n" +
                    "                'twitter' : 'butiqlive',\n" +
                    "                'workplace' : 'FITco'\n" +
                    "            },\n" +
                    "            {\n" +
                    "                'biography' : 'Claudia Sosa, dise??adora industrial y l??der de CX Design de BBVA. Su fuerte, aplicar innovaci??n en el dise??o de productos y servicios. con tecnolog??as especializadas en mejorar la experiencia del cliente.',\n" +
                    "                'category' : 4,\n" +
                    "                'image' : 'https://pbs.twimg.com/profile_images/770787948719505408/KSvKmi9y_400x400.jpg',\n" +
                    "                'jobtitle' : 'Head of CX Design',\n" +
                    "                'name' : 'Claudia Sosa',\n" +
                    "                'twitter' : 'claudiagizela',\n" +
                    "                'workplace' : 'BBVA'\n" +
                    "            },\n" +
                    "            {\n" +
                    "                'biography' : '??? Never stop running ??? Innovation, my love ??? Let???s talk #OpenInnovation, #APIs & #OpenBanking ??? @archivomodamex',\n" +
                    "                'category' : 14,\n" +
                    "                'image' : 'https://pbs.twimg.com/profile_images/845058986034397185/T6ixCftF_400x400.jpg',\n" +
                    "                'jobtitle' : 'Innovation Manager',\n" +
                    "                'name' : 'Elina Corona',\n" +
                    "                'twitter' : 'ninscorona',\n" +
                    "                'workplace' : 'Open Banking'\n" +
                    "            },\n" +
                    "            {\n" +
                    "                'biography' : 'Co-fundador y CEO de Iconic, empresario y estratega en servicios tecnol??gicos. Reconocido en el MIT Technology Review Innovator under 35 Awards como innovador social por su proyecto Votosocial.org',\n" +
                    "                'category' : 8,\n" +
                    "                'image' : 'https://pbs.twimg.com/profile_images/1102611265720107009/rUulO29A_400x400.png',\n" +
                    "                'jobtitle' : 'CTO - Co-founder',\n" +
                    "                'name' : 'Jorge Garcia',\n" +
                    "                'twitter' : 'jagbolanos',\n" +
                    "                'workplace' : 'Iconic'\n" +
                    "            },\n" +
                    "            {\n" +
                    "                'biography' : 'Fue de los primeros webmasters en Guatemala. Su carrera inici?? en julio de 1997 cuando fund?? Maestros del Web, plataforma que conten??a cursos, noticias, tips y una gran comunidad de desarrolladores web con una misi??n: difundir el uso del internet y sus tecnolog??as. Durante 15 a??os, esta plataforma se convirti?? en un referente a nivel Latinoamericano. A??os m??s tarde, en 2004, cofund?? Guate360, un blog dedicado a la comunidad guatemalteca donde se promociona al pa??s a trav??s de fotos, recetas de comida, tours virtuales, directorio de hoteles, restaurantes y atractivos tur??sticos. En 2009 vendi?? sus acciones. Las iniciativas de Christian continuaron y su amplio conocimiento en el campo le abri?? muchas oportunidades para continuar emprendiendo. Fue as?? como en marzo de 2012 cofunda Platzi, una plaza dedicada a la educaci??n en l??nea. Desde sus inicios, la plataforma ha roto esquemas de la educaci??n en la web y se dedica a ense??ar cursos sobre dise??o, marketing y programaci??n, impartidos por l??deres de la industria tecnol??gica que promueven el desarrollo de habilidades tecnol??gicas profesionales. Actualmente posee m??s de 600 mil estudiantes en todo el mundo y tiene una tasa de finalizaci??n del 70%. En Platzi, Christian se preocupa por hablar con los estudiantes, desarrollar la estrategia de contenido, gestionar la log??stica, los recursos financieros y los recursos humanos de la empresa.',\n" +
                    "                'category' : 2,\n" +
                    "                'image' : 'https://pbs.twimg.com/profile_images/703539825853464577/jppQNmXD_400x400.jpg',\n" +
                    "                'jobtitle' : 'Co-fundador',\n" +
                    "                'name' : 'Christian Van Der Henst',\n" +
                    "                'twitter' : 'cvander',\n" +
                    "                'workplace' : 'Platzi'\n" +
                    "            },\n" +
                    "            {\n" +
                    "                'biography' : 'Periodista. De #Michoac??n. Madrile??a adoptiva. Siempre una escala en #GDL. No como pizza con pi??a. Le voy al @ClubAmerica. Defe??a.',\n" +
                    "                'category' : 13,\n" +
                    "                'image' : 'https://pbs.twimg.com/profile_images/1231252218562646019/X_NpdqKK_400x400.jpg',\n" +
                    "                'jobtitle' : 'Periodista',\n" +
                    "                'name' : 'Veronica Calderon',\n" +
                    "                'twitter' : 'veronicalderon',\n" +
                    "                'workplace' : ''\n" +
                    "            },\n" +
                    "            {\n" +
                    "                'biography' : 'Colombiano, fue elegido uno de los 20 latinos m??s influyentes del a??o en la industria de la tecnolog??a por CNET en Espa??ol, al lado de personalidades que trabajan en empresas como Tesla, Google, Apple, Microsoft, Samsung y GitHub. Cumpli?? 33 a??os hace poco, pero ten??a solo 17 a??os cuando fund?? Cristalab.com, cuya comunidad se convirti?? en una referencia en dise??o interactivo, desarrollo web y programaci??n. Antes de ser el socio de Christian, era su competidor. Arrancaron esto con un streaming semanal, que hoy reconoces como Platzi Live cada semana. Todo cambi?? entre otras cosas con un viaje que hicieron juntos a Jap??n - la cultura japonesa es una pasi??n que comparten. Son parte de la red Endeavor y de los alumni de Y Combinator. Este importante programa de apoyo a emprendimientos los acept?? en su versi??n del 2015, donde fueron la primera empresa de la regi??n cuya audiencia estaba en Latinoam??rica. Freddy est?? a cargo de dirigir la empresa, de reclutamiento y tambi??n es de nuestro m??s reconocidos profesores. Adem??s del curso de programaci??n b??sica, tambi??n es uno de los instructores de nuestro taller de startups, exclusivo para los estudiantes con suscripci??n anual de Platzi. Su autor favorito es el escritor de ciencia ficci??n Robert A. Heinlein. Es aficionado al tiro deportivo, a la astronom??a??? y al lanzamiento de drones.',\n" +
                    "                'category' : 1,\n" +
                    "                'image' : 'https://pbs.twimg.com/profile_images/1062767896269590528/vOsDt9up_400x400.jpg',\n" +
                    "                'jobtitle' : 'CEO',\n" +
                    "                'name' : 'Freddy Vega',\n" +
                    "                'twitter' : 'freddier',\n" +
                    "                'workplace' : 'Platzi'\n" +
                    "            },\n" +
                    "            {\n" +
                    "                'biography' : 'Cada cuadro tiene un proceso que debe hacerse antes de la acci??n de juego.',\n" +
                    "                'category' : 17,\n" +
                    "                'image' : 'https://pbs.twimg.com/profile_images/976117964591087617/61w43dr0_400x400.jpg',\n" +
                    "                'jobtitle' : 'Production Manager',\n" +
                    "                'name' : 'Erika Oregel',\n" +
                    "                'twitter' : 'oregeler',\n" +
                    "                'workplace' : 'Platzi'\n" +
                    "            },\n" +
                    "            {\n" +
                    "                'biography' : 'Course Director del equipo de Education en Platzi. Blogguera y periodista del Universal en M??xico, especialista en t??cnicas orales y escritas del periodismo con una amplia visi??n en el mundo digital.',\n" +
                    "                'category' : 7,\n" +
                    "                'image' : 'https://pbs.twimg.com/profile_images/674117824135081984/p5SJ33YJ_400x400.jpg',\n" +
                    "                'jobtitle' : 'Course Director',\n" +
                    "                'name' : 'Isis Garc??a',\n" +
                    "                'twitter' : 'IsisConVelo',\n" +
                    "                'workplace' : 'Platzi'\n" +
                    "            },\n" +
                    "            {\n" +
                    "                'biography' : 'Director and cinematographer. Writer, Podcaster and teacher of audiovisual content.',\n" +
                    "                'category' : 16,\n" +
                    "                'image' : 'https://media-exp2.licdn.com/dms/image/C4E03AQF-6RBsJ6-iDA/profile-displayphoto-shrink_800_800/0?e=1585180800&v=beta&t=yLMYrEr0O19UdV30I2Ff2LgjMDDyoWH9qpDGSIXNgA8',\n" +
                    "                'jobtitle' : 'Writer',\n" +
                    "                'name' : 'Nicolay Coral',\n" +
                    "                'twitter' : 'nicolaycoral',\n" +
                    "                'workplace' : ''\n" +
                    "            },\n" +
                    "            {\n" +
                    "                'biography' : 'Mario Valle es uno de los mexicanos m??s prominentes de Silicon Valley. Fue pionero de la industria de videojuegos en Am??rica Latina y por 11 a??os fue ejecutivo de la gigante Electronic Arts.\u2028??Por qu??, entonces, dejarlo todo para lanzarse a ser inversionista?\u2028Mario (donante y fan #terco de la primera hora) nos cuenta que estaba c??modo y contento en EA. Pero la oportunidad que vio de invertir en videojuegos de creadores independientes en Asia, Europa, Am??rica Latina y hasta ??frica le pareci?? demasiado grande para dejarla pasar.\u2028Lanz?? Altered Ventures, un fondo que invierte como si fuera una productora de Hollywood: Le mete dinero a los proyectos, los videojuegos, y no a las empresas. Por lo tanto, no les pide a los desarrolladores que le cedan un porcentaje de propiedad de sus compa????as, lo que ???dice??? en regiones como Am??rica Latina lleva a abusos de parte de los inversionistas. Mario tiene 36 millones de d??lares para invertir en nuevos t??tulos y parte de su trabajo para lanzar el fondo fue viajar por el mundo jugando videojuegos para conocer qu?? es lo que viene. Ya invirti?? en un juego innovador hecho en Noruega (que se lanza el 21 de junio en Nintendo Switch) y pronto vienen m??s.',\n" +
                    "                'category' : 3,\n" +
                    "                'image' : 'https://pbs.twimg.com/profile_images/1177427481831194625/MGmAHgel_400x400.jpg',\n" +
                    "                'jobtitle' : 'Angel Investor & Co-founder',\n" +
                    "                'name' : 'Mario Valle',\n" +
                    "                'twitter' : 'bilbeny',\n" +
                    "                'workplace' : 'Altered Ventures'\n" +
                    "            },\n" +
                    "            {\n" +
                    "                'biography' : 'Tuerto en pa??s de ciegos | Nerd empedernido | Constructor de marcas | Estratega digital',\n" +
                    "                'category' : 15,\n" +
                    "                'image' : 'https://pbs.twimg.com/profile_images/1125995646585065474/oJkHqDhY_400x400.png',\n" +
                    "                'jobtitle' : 'Director',\n" +
                    "                'name' : 'Ruben Gomez',\n" +
                    "                'twitter' : 'soyrubengomez',\n" +
                    "                'workplace' : 'gom360'\n" +
                    "            }\n" +
                    "        ]"
        )

        val jsonArr2 = JSONArray(
            "[\n" +
                    "            {\n" +
                    "                \"datetime\" : 1564830000,\n" +
                    "                \"description\" : \"Yo les voy a hablar el d??a de hoy de un tema que si soy exitoso, contrario a lo que algunos de ustedes me conocen saben que juego muchos videojuegos y que trabajo con ellos, toda mi vida llevo 21 a??os hablando en p??blico a lo largo de la industria de la tecnolog??a y alrededor por supuesto de la oportunidad tremenda que los videojuegos, la realidad virtual y la realidad aumentada ofrecen, sigo convencido en ello y sigo trabajando en eso. Pero estoy aqu?? con otro sombrero, el d??a de hoy si soy exitoso van a terminar con dos sentimientos, un poco de miedo y sobretodo el miedo que desemboca en la acci??n.\",\n" +
                    "                \"speaker\" : \"Mario Valle\",\n" +
                    "                \"tag\" : \"Negocios\",\n" +
                    "                \"title\" : \"Ahorrar no te va a salvar del futuro\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"datetime\" : 1564862400,\n" +
                    "                \"description\" : \"En esta charla Erika Oregel del equipo de Platzi nos invita a explorar nueva forma de adquirir gustos y pasiones, nos invita a procrastinar de forma consciente. \",\n" +
                    "                \"speaker\" : \"Erika Oregel\",\n" +
                    "                \"tag\" : \"Procastinaci??n\",\n" +
                    "                \"title\" : \"Procrastinar puede ser el alimento de tus futuras pasiones\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"datetime\" : 1564860000,\n" +
                    "                \"description\" : \"Periodismo en 2019: Constar historias no debe ser aburrido.\",\n" +
                    "                \"speaker\" : \"Veronica Calder??n\",\n" +
                    "                \"tag\" : \"Periodismo\",\n" +
                    "                \"title\" : \"Periodismo en 2019: Constar historias no debe ser aburrido.\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"datetime\" : 1564861200,\n" +
                    "                \"description\" : \"Tener una marca personal es fundamental para tu desarrollo profesional. Construir un portafolio de proyectos y fortalecer tu presencia online te ayudar?? a resaltar para ampliar tus oportunidades laborales, conseguir un mejor empleo o crear tu propio negocio.\",\n" +
                    "                \"speaker\" : \"Rub??n G??mez\",\n" +
                    "                \"tag\" : \"Dise??o\",\n" +
                    "                \"title\" : \"??Tienes una marca personal o solo redes sociales?\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"datetime\" : 1564837200,\n" +
                    "                \"description\" : \"Hoy quiero hablarles de los dos tipos de personas que existen en el mundo, hay personas que consumen y hay personas que crean, todos somos de las primeras, todo el tiempo estamos consumiendo, consumimos tecnolog??a, consumimos libros, pel??culas, series, comida, el problemas es que no todo el mundo esta creando y cuando me refiero a crear me refiero a crear productos servicios, eventos, cosas que le aporten algo a la comunidad o al mundo, porque es un problema que no tanta gente este creando como la que esta consumiendo, porque le estamos quitando al mundo mas de lo que le dejamos, no estamos dejando este mundo mejor de como lo encontramos, eso genera consumismo y eso es un problema.\",\n" +
                    "                \"speaker\" : \"Cesar Fajardo\",\n" +
                    "                \"tag\" : \"Content\",\n" +
                    "                \"title\" : \"Un 'gracias' vale m??s que un mill??n de views\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"datetime\" : 1564858800,\n" +
                    "                \"description\" : \"En esta charla Andrea Baba, CEO de FITco, nos explica c??mo llevar una vida saludable sin muchos sacrificios para complementar tu carrera profesional. \",\n" +
                    "                \"speaker\" : \"Andrea Baba\",\n" +
                    "                \"tag\" : \"Firness\",\n" +
                    "                \"title\" : \"Una vida FIT te hace un mejor profesional\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"datetime\" : 1564826400,\n" +
                    "                \"description\" : \"A lo largo de mi presentaci??n les contar?? algunas historias para que nunca paren de aprender. Cada semana gracias al equipo incre??ble de Platzi a mi me encanta contar las noticias porque entender nuestra industria es aprender a dominarla solo cuando entendemos como esta pasando y como las grandes empresas est??n creando podemos ser parte de ??sta transformaci??n entonces algo que me divierte a mi es leer es compartir y es analizar algunas de estas noticias, a veces no hago tan buen trabajo, a veces entiendo 2 o 3 cosas que est??n pasando con el mundo, pero cada vez m??s estoy haciendo un esfuerzo porque estas noticias sean m??s locales.   \",\n" +
                    "                \"speaker\" : \"Christian Van Der Henst\",\n" +
                    "                \"tag\" : \"Motivacional\",\n" +
                    "                \"title\" : \"Dise??ador, programador, creador y luego emprendedor\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"datetime\" : 1564861800,\n" +
                    "                \"description\" : \"En esta charla Nicolay Coral nos explica c??mo construimos sentimientos a trav??s del c??mulo de emociones repetitivas  y c??mo al lograr identificar qu?? y qui??n despiertan nuestras emociones podemos desaprender a ser felices. \",\n" +
                    "                \"speaker\" : \"Nicolay Coral\",\n" +
                    "                \"tag\" : \"Felicidad\",\n" +
                    "                \"title\" : \"Desaprender a ser Feliz | Diferencia entre emociones y sentimientos\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"datetime\" : 1564840800,\n" +
                    "                \"description\" : \"Les quiero comentar de c??mo se pueden convertir en un MVP, en el MVP que el mundo necesita, haci??ndose una pregunta, ??Qui??nes saben que es un MVP?, quiero comentarles como poder hacer el MVP de su equipo de desarrollo.\",\n" +
                    "                \"speaker\" : \"Pablo Villanueva\",\n" +
                    "                \"tag\" : \"Desarrollo\",\n" +
                    "                \"title\" : \"C??mo convertirte en la persona m??s valiosa de una empresa\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"datetime\" : 1564860600,\n" +
                    "                \"description\" : \"Redefiniendo la competencia en el mercado financiero: Open Banking\",\n" +
                    "                \"speaker\" : \"Elina Corona\",\n" +
                    "                \"tag\" : \"Bank\",\n" +
                    "                \"title\" : \"Redefiniendo la competencia en el mercado financiero: Open Banking\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"datetime\" : 1564848000,\n" +
                    "                \"description\" : \"Somos una empresa enfocada en el desarrollo de aplicaciones m??viles del lado de la ingenier??a y tuvimos por primera vez a una dise??adora en el equipo, al principio la ve??amos como un adherido al equipo, luego empezamos un proyecto y ahora vengo a comentarles lo que pas?? con la comunicaci??n con personas que son de otras ??reas.\",\n" +
                    "                \"speaker\" : \"Jorge Garc??a\",\n" +
                    "                \"tag\" : \"Git\",\n" +
                    "                \"title\" : \"Git, la base de la colaboraci??n mucho m??s all?? del c??digo\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"datetime\" : 1564855200,\n" +
                    "                \"description\" : \"Tuve una idea de negocio de vender las im??genes de un tel??fono, m??s de 1 personas me dijo que es la idea m??s est??pida que haya escuchado, pero yo estaba viendo el futuro que los tel??fonos estaban marcando tendencia y que quiz?? hace a??os el que uno pueda vender sus fotos a una empresa grande haya sido una locura, pero hoy en d??a puedes convertir la c??mara de tu tel??fono un negocio.\",\n" +
                    "                \"speaker\" : \"Manuel Villegas\",\n" +
                    "                \"tag\" : \"Emprendimiento\",\n" +
                    "                \"title\" : \"La c??mara de tu tel??fono puede ser un negocio\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"datetime\" : 1564859400,\n" +
                    "                \"description\" : \"En esta charla Ludwin Cuevas nos ense??a c??mo gestiona a un equipo de 20 personas en el quipo de producci??n audiovisual de Platzi y nos comparte 5 tips para lograrlo   Los tips que @winiberto nos comparte son:  - Contrata a personas mejores que t??. - Tener claras las expectativas - Reuniones recurrentes - Crear conexiones humanas - Pedir retroalimentaci??n\",\n" +
                    "                \"speaker\" : \"Ludwin Cuevas\",\n" +
                    "                \"tag\" : \"Creative\",\n" +
                    "                \"title\" : \"5 consejos para liderar equipos grandes\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"datetime\" : 1564844400,\n" +
                    "                \"description\" : \"Uno de los ejercicios hechos por la mayor??a de los speakers profesionales, para mejorar como dan un mensaje, la premisa es f??cil, no poner atenci??n en lo que est??n diciendo, sino en c??mo lo est??n diciendo y vengo a compartirles algunas t??cnicas que aprend??.\",\n" +
                    "                \"speaker\" : \"Isis Garc??a\",\n" +
                    "                \"tag\" : \"Voz\",\n" +
                    "                \"title\" : \"C??mo comunicarte en un mundo saturado de informaci??n\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"datetime\" : 1564833600,\n" +
                    "                \"description\" : \"El t??tulo de la charla se llama Workshops de alto impacto para ideas de alto impacto, yo pienso en mi experiencia personal en el banco, mas bien son Workshops de alto impacto en la vida, yo entr?? a BBVA hace 3 a??os, soy dise??adora industrial de la UNAM, empec?? como todos con un trabajo peque??o, muy duro encontrar mi primer trabajo y me pagaban una miseria y ustedes debieron vivir algo as??, entonces BBVA me dio la oportunidad de entrar a trabajar a un lugar decente y vengo a compartirles acerca de mi experiencia.\",\n" +
                    "                \"speaker\" : \"Claudia Sosa\",\n" +
                    "                \"tag\" : \"Negocios\",\n" +
                    "                \"title\" : \"Crear workshops para comprender, idear y decidir\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"datetime\" : 1564851600,\n" +
                    "                \"description\" : \"Hoy les voy a hablar de 5 formas de mentir con estad??stica.  Vamos a hablar de distintos m??todos estad??sticos que se utilizan y para que se utilizan en el diario vivir y tecnolog??a.\",\n" +
                    "                \"speaker\" : \"Juan Pablo Rojas\",\n" +
                    "                \"tag\" : \"Estad??stica\",\n" +
                    "                \"title\" : \"5 formas de mentir (o ser enga??ado) con datos\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"datetime\" : 1564822800,\n" +
                    "                \"description\" : \"Hoy vamos a hablar de como desarrollar tu carrera profesional pero en tecnolog??a, porque hay otras carreras que tienen menos crecimiento que la carrera de tecnolog??a, cuando ustedes trabajan en tecnolog??a ustedes entran en una carrera que tiene desempleo negativo, una carrera que tiene la demanda m??s fuerte del mercado, si nosotros vemos los sueldos en los ??ltimos a??os en tecnolog??a, en el 2013 el desarrollador de software promedio en Latinoam??rica ganaba alrededor de 1100 d??lares, hoy en el 2018 el desarrollador de software promedio gana 1650 d??lares, pero el top 25% de desarrolladores de software ganan 2500 d??lares en promedio, normalmente el rango el gradiente de sueldos de los estudiantes de Platzi que estudian un a??o o m??s es de 1000 a 3500 d??lares al mes en Latinoam??rica.\",\n" +
                    "                \"speaker\" : \"Freddy Vega\",\n" +
                    "                \"tag\" : \"Motivacional\",\n" +
                    "                \"title\" : \"C??mo desarrollar tu carrera profesional en tecnolog??a\"\n" +
                    "            }\n" +
                    "        ]"
        )

        val firebaseFirestore = FirebaseFirestore.getInstance()

        for (i in 0 until jsonArr.length()) {
            val aux = jsonArr.get(i) as JSONObject
            val speaker = Speaker()
            speaker.name = aux.getString("name")
            speaker.jobTitle = aux.getString("jobtitle")
            speaker.workPlace = aux.getString("workplace")
            speaker.biography = aux.getString("biography")
            speaker.twitter = aux.getString("twitter")
            speaker.image = aux.getString("image")
            speaker.category = aux.getInt("category")

            firebaseFirestore.collection("speakers").document().set(speaker)
        }

        for(i in 0 until jsonArr2.length()) {
            val aux = jsonArr2.get(i) as JSONObject
            val cal = Calendar.getInstance()
            cal.timeInMillis = aux.getLong("datetime") * 1000

            val conference = Conference()
            conference.title = aux.getString("title")
            conference.description = aux.getString("description")
            conference.tag = aux.getString("tag")
            conference.datetime = cal.time
            conference.speaker = aux.getString("speaker")

            firebaseFirestore.collection("conferences").document().set(conference)
        }

         */
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.fragmentContent)
        return navController.navigateUp()
    }

}