USE [CARRERA]
GO

CREATE TABLE [dbo].[ALUMNO](
	[ID] [int] NOT NULL,
	[APEL_NOMBRE] [varchar](50) NOT NULL,
 CONSTRAINT [PK_ALUMNO] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

CREATE TABLE [dbo].[MATERIA](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[DESCRIPCION] [varchar](50) NOT NULL,
 CONSTRAINT [PK_MATERIA] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


CREATE TABLE [dbo].[FINALES](
	[ID] [int] NOT NULL,
	[ID_ALUMNO] [int] NOT NULL,
	[ID_MATERIA] [int] NOT NULL,
	[NOTA] [numeric](4, 2) NOT NULL,
 CONSTRAINT [PK_FINALES] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


CREATE TABLE [dbo].[USUARIO](
	[USUARIO] [varchar](50) NOT NULL,
	[PASSWORD] [varchar](50) NOT NULL,
	[PERFIL] [varchar](50) NOT NULL,
	[NOMBRE] [varchar](50) NOT NULL,
 CONSTRAINT [PK_USUARIO] PRIMARY KEY CLUSTERED 
(
	[USUARIO] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

CREATE TABLE [dbo].[ALUMNO_USUARIO](
	[ID_ALUMNO] [int] NOT NULL,
	[USUARIO] [varchar](50) NOT NULL,
 CONSTRAINT [PK_ALUMNO_USUARIO] PRIMARY KEY CLUSTERED 
(
	[ID_ALUMNO] ASC,
	[USUARIO] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[FINALES]  WITH CHECK ADD  CONSTRAINT [FK_FINALES_ALUMNO] FOREIGN KEY([ID_ALUMNO])
REFERENCES [dbo].[ALUMNO] ([ID])
GO

ALTER TABLE [dbo].[FINALES] CHECK CONSTRAINT [FK_FINALES_ALUMNO]
GO

ALTER TABLE [dbo].[FINALES]  WITH CHECK ADD  CONSTRAINT [FK_FINALES_MATERIA] FOREIGN KEY([ID_MATERIA])
REFERENCES [dbo].[MATERIA] ([ID])
GO

ALTER TABLE [dbo].[FINALES] CHECK CONSTRAINT [FK_FINALES_MATERIA]
GO


ALTER TABLE [dbo].[ALUMNO_USUARIO]  WITH CHECK ADD  CONSTRAINT [FK_ALUMNO_USUARIO_ALUMNO] FOREIGN KEY([ID_ALUMNO])
REFERENCES [dbo].[ALUMNO] ([ID])
GO

ALTER TABLE [dbo].[ALUMNO_USUARIO] CHECK CONSTRAINT [FK_ALUMNO_USUARIO_ALUMNO]
GO

ALTER TABLE [dbo].[ALUMNO_USUARIO]  WITH CHECK ADD  CONSTRAINT [FK_ALUMNO_USUARIO_USUARIO] FOREIGN KEY([USUARIO])
REFERENCES [dbo].[USUARIO] ([USUARIO])
GO

ALTER TABLE [dbo].[ALUMNO_USUARIO] CHECK CONSTRAINT [FK_ALUMNO_USUARIO_USUARIO]
GO